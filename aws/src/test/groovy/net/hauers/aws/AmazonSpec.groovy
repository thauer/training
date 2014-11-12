package net.hauers.aws

import spock.lang.*

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.model.LaunchSpecification;
import com.amazonaws.services.ec2.model.RequestSpotInstancesRequest;
import com.amazonaws.services.ec2.model.RequestSpotInstancesResult;
import com.amazonaws.services.ec2.model.SpotInstanceRequest;
import com.amazonaws.services.ec2.model.GroupIdentifier;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.ec2.model.DescribeSpotInstanceRequestsResult;
import com.amazonaws.services.ec2.model.DescribeSpotInstanceRequestsRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.TerminateInstancesResult;
import com.amazonaws.services.ec2.model.TerminateInstancesRequest;
import java.util.List;

class AmazonSpec extends Specification {

  def "An authenticated call can be made"() {

    given:  "An AWS EC2 handle"
    AmazonEC2 ec2Client = new AmazonEC2Client()

    when: "Extracting the information from a describeRegions() call"
    def regions = ec2Client.describeRegions().regions

    then: "The returned list contains an entry corresponding to region us-east-1"
    regions.any{it.regionName == "us-east-1"}
  }

  @IgnoreRest
  def "A single spot instance can be requested, it should be fulfilled and started"() {

    given: "An AWS EC2 handle"
    AmazonEC2 ec2Client = new AmazonEC2Client().withRegion(Region.getRegion(Regions.EU_WEST_1));

    and: "A lauch specification shared by the instances to be started"
    LaunchSpecification launchSpecification = new LaunchSpecification().
        withAllSecurityGroups(new GroupIdentifier().withGroupId("sg-29c16d4c")).
        withImageId("ami-22298b55").
        withInstanceType(InstanceType.M1Medium).
        withSubnetId("subnet-18ee497d");

    when: "Requesting a single spot instance with a given price and launch Specification"
    List<SpotInstanceRequest> spotInstanceRequests =
        ec2Client.requestSpotInstances(new RequestSpotInstancesRequest("0.050").
                                            withInstanceCount(1).
                                            withLaunchSpecification(launchSpecification)).
          getSpotInstanceRequests()

    then: "The extracted spot instance requests collection has size 1"
    spotInstanceRequests.size() == 1;

    when: "Querying EC2 repeatedly for all spot requests reaching 'fulfilled' status"
    String spotInstanceRequestId = spotInstanceRequests.iterator().next().getSpotInstanceRequestId();
    DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest = 
        new DescribeSpotInstanceRequestsRequest().
            withSpotInstanceRequestIds(spotInstanceRequestId)

    for(Boolean fulfilled = false; !fulfilled; ) {
      sleep 30000;
      fulfilled = true;
      spotInstanceRequests = ec2Client.describeSpotInstanceRequests(describeSpotInstanceRequestsRequest).
          getSpotInstanceRequests();
      for(SpotInstanceRequest sir: spotInstanceRequests) {
        fulfilled &= sir.getStatus().getCode().equals("fulfilled");
      }      
    }

    then:
    spotInstanceRequests.size() == 1;

    when: "Requesting the description of the single instance"
    String instanceId = spotInstanceRequests.iterator().next().getInstanceId();
    DescribeInstancesResult describeInstancesResult = ec2Client.describeInstances(
        new DescribeInstancesRequest().withInstanceIds(instanceId));

    then: "There is a single reservation with a single instance"
    List<Reservation> reservations = describeInstancesResult.getReservations();
    reservations.size() == 1;

    and: "There is a single instance"
    List<Instance> instances = reservations.iterator().next().getInstances();
    instances.size() == 1;

    and: "The instance is is pending or running"
    def instance = instances.iterator().next();
    def instanceState = instance.getState().getName()
    instanceState.equals("pending") || instanceState.equals("running");

    when: "Calling terminateInstances() with the single instance id"
    TerminateInstancesResult terminateInstancesResult = 
        ec2Client.terminateInstances(new TerminateInstancesRequest().
                                            withInstanceIds(instance.getInstanceId()));

    then: "The instance is shutting down"
    terminateInstancesResult.getTerminatingInstances().every{ 
      it.getCurrentState().getName().equals("shutting-down")}

  }

  def "An instance can be queried"() {

    given: "A running instance with known instance ID and private IP"
    def myInstanceId = "i-c22e6d82"
    def myIpAddress = "10.13.190.12"

    and: "An AWS EC2 handle"
    AmazonEC2 ec2Client = new AmazonEC2Client().withRegion(Region.getRegion(Regions.EU_WEST_1));

    when: "Querying the description of a given instance"
    DescribeInstancesResult dir = ec2Client.describeInstances(
        new DescribeInstancesRequest().withInstanceIds(myInstanceId));

    then: "The response is a list of reservations, each a list of instances for a total of 1"
    List<Instance> instances = new ArrayList<Instance>()
    for(Reservation reservation: dir.getReservations()){
      for(Instance instance: reservation.getInstances()){
        instances.add(instance)
      }
    }
    instances.size() == 1;

    and: "The private IP number of the instance matches the one on record"
    instances[0].getPrivateIpAddress().equals(myIpAddress);
  }

  def "An instance can be terminated"() {

    given: "A running instance with known instance ID and private IP"
    def myInstanceId = "i-223801c7"

    and: "An AWS EC2 handle"
    AmazonEC2 ec2Client = new AmazonEC2Client().withRegion(Region.getRegion(Regions.EU_WEST_1));

    when: "Calling terminateInstances"
    TerminateInstancesResult terminateInstancesResult = 
        ec2Client.terminateInstances(new TerminateInstancesRequest().
                                            withInstanceIds(myInstanceId));

    then: 
    terminateInstancesResult.getTerminatingInstances().every{ instance ->
      instance.getCurrentState().getName().equals("shutting-down")}
  }
}