package net.hauers.aws

import spock.lang.*

import com.amazonaws.services.ec2.model.Instance;

class SimpleAwsSpec extends Specification {

  @Ignore
  def "A single instance can be queried"() {

    given:  "An AWS EC2 handle"
    SimpleAws aws = new SimpleAws()

    when: 
    Instance instance = aws.querySingleInstance(instanceId);

    then: 
    instance.getInstanceId().equals(instanceId);

    where:
    instanceId << ["i-28b188cd"]
  }

  def "A set of spot instances can be requested, they should be fulfilled and started"() {

    given: "An AWS EC2 handle"
    SimpleAws aws = new SimpleAws()

    when: 
    def instances = aws.launchSpots(3)

    then:
    instances.size() == 3
  }
}