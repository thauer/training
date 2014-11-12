Amazon AWS Convenience Wrappers for EC2
========

This is a thin wrapper on the [AWS SDK for Java](https://github.com/aws/aws-sdk-java/tree/master/aws-java-sdk-ec2).

Mostly developed as a coding exercise

# Distribution

Have not thought about license, thus there is not one yet. For the moment, javadoc is [here](https://dl.dropboxusercontent.com/u/23240137/SimpleAws/javadoc/index.html). Maven repo is [here](ttps://dl.dropboxusercontent.com/u/23240137/maven-repository)

# Example

The following groovy script is included and illustrates the kind of things this is good for

```
#!/usr/bin/env groovy 

@GrabResolver(name='thauer', 
  root='https://dl.dropboxusercontent.com/u/23240137/maven-repository',
  m2Compatible='true')
@Grab('thauer:aws:0.1.0')
import net.hauers.aws.SimpleAws

println new SimpleAws().querySingleInstance("i-59185b19")
```
