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
}