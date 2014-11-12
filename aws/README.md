Amazon AWS Convenience Wrappers for EC2
========

This is a thin wrapper on the [AWS SDK for Java](https://github.com/aws/aws-sdk-java/tree/master/aws-java-sdk-ec2).

Mostly developed as a coding exercise

# Distribution

Have not thought about license, thus there is not one yet. For the moment, javadoc is [here](http://bit.ly/thauer-aws-javadoc). Maven repo is [here](http://bit.ly/thauer-aws-maven)

# Example

The following groovy script is included and illustrates how this is meant to be used:

```
#!/usr/bin/env groovy 

@GrabResolver('https://dl.dropboxusercontent.com/u/23240137/maven-repository')
@GrabConfig(systemClassLoader = true)
@Grab('thauer:aws:0.1.0')
import net.hauers.aws.SimpleAws

println new SimpleAws().querySingleInstance("i-59185b19")
```
