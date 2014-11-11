package net.hauers.aws

import spock.lang.*

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;

class AmazonSpec extends Specification {

  def "An authenticated call can be made"() {

    given:  "An AWS EC2 handle"
    AmazonEC2 ec2Client = new AmazonEC2Client()

    when: "Extracting the information from a describeRegions() call"
    def regions = ec2Client.describeRegions().regions

    then: "The returned list contains an entry corresponding to region us-east-1"
    regions.any{it.regionName == "us-east-1"}
  }

  def "Can request spot instances"() {

    RequestSpotInstancesResult result = 
      requestSpotInstances(RequestSpotInstancesRequest requestSpotInstancesRequest)

    expect: true
  }
}