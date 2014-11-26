/**
 * Amazon AWS Convenience Wrappers for EC2<p>
 * This is a thin wrapper on the AWS SDK for Java.
 * <p>Mostly developed as a <a href="http://bit.ly/thauer-aws-github">coding exercise</a></p>
 * <h3>Distribution</h3>
 * <p>Have not thought about license, thus there isn't one yet.
 *
 * <h3>Example</h3>
 * The following groovy script is included and illustrates how this is meant to be used:
 *
 * <pre>
 * #!/usr/bin/env groovy 
 * &#64;GrabResolver('https://dl.dropboxusercontent.com/u/23240137/maven-repository')
 * &#64;GrabConfig(systemClassLoader = true)
 * &#64;Grab('thauer:aws:0.1.0')
 * import net.hauers.aws.SimpleAws
 * 
 * println new SimpleAws().querySingleInstance("i-59185b19")
 *
 * </pre>
 */
package net.hauers.aws;