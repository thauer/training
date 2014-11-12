package net.hauers.aws;

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
import java.util.ArrayList;


class SimpleAws extends AmazonEC2Client{

  public SimpleAws() {
    super();
    setRegion(Region.getRegion(Regions.EU_WEST_1));
  }

  public Instance querySingleInstance(String instanceId) {

    DescribeInstancesResult describeInstancesResult = describeInstances(
        new DescribeInstancesRequest().withInstanceIds(instanceId));

    List<Reservation> reservations = describeInstancesResult.getReservations();
    assert reservations.size() == 1;

    List<Instance> instances = reservations.iterator().next().getInstances();
    assert instances.size() == 1;

    return instances.iterator().next();
  }


  public List<Instance> launchSpots(int spotCount) {

    LaunchSpecification launchSpecification = new LaunchSpecification().
        withAllSecurityGroups(new GroupIdentifier().withGroupId("sg-29c16d4c")).
        withImageId("ami-22298b55").
        withInstanceType(InstanceType.M1Medium).
        withSubnetId("subnet-18ee497d");

    List<SpotInstanceRequest> spotInstanceRequests =
        requestSpotInstances(new RequestSpotInstancesRequest("0.050").
                                            withInstanceCount(spotCount).
                                            withLaunchSpecification(launchSpecification)).
            getSpotInstanceRequests();

    List<String> spotInstanceRequestIds = new ArrayList<String>();
    for(SpotInstanceRequest spotInstanceRequest: spotInstanceRequests) {
      spotInstanceRequestIds.add(spotInstanceRequest.getSpotInstanceRequestId());
    }

    DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest = 
        new DescribeSpotInstanceRequestsRequest().
            withSpotInstanceRequestIds(spotInstanceRequestIds);

    long threshold = System.currentTimeMillis() + 1000*60*10;
    Boolean fulfilled = false;
    while(System.currentTimeMillis() < threshold && !fulfilled) {
      try{
        Thread.sleep(30000);
      } catch(InterruptedException e) {
        threshold = System.currentTimeMillis() - 1;
      }
      fulfilled = true;
      spotInstanceRequests = describeSpotInstanceRequests(describeSpotInstanceRequestsRequest).
          getSpotInstanceRequests();
      for(SpotInstanceRequest spotInstanceRequest: spotInstanceRequests) {
        fulfilled &= spotInstanceRequest.getStatus().getCode().equals("fulfilled");
      }
    }

    if(!fulfilled) {
      System.out.println("NOT ALL FULFILLED - TODO");
    }

    List<Instance> instances = new ArrayList<Instance>();
    for(SpotInstanceRequest spotInstanceRequest: spotInstanceRequests){
      DescribeInstancesResult describeInstancesResult = describeInstances(
          new DescribeInstancesRequest().withInstanceIds(spotInstanceRequest.getInstanceId()));

      for(Reservation reservation: describeInstancesResult.getReservations()){
        for(Instance instance: reservation.getInstances()){
          instances.add(instance);
        }
      }
    }
    return instances;
  }
}