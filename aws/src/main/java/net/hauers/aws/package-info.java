/**
 * Amazon AWS Convenience Wrappers for EC2<p>
 * This is a thin wrapper on the AWS SDK for Java.
 * <p>Mostly developed as a coding exercise</p>
 * <h3>Distribution</h3>
 * <p>Have not thought about license, thus there isn't one yet.
 *
 * <h3>Example</h3>
 * The following groovy script is included and illustrates the kind of things this is good for
 *
 * <pre>
 * #!/usr/bin/env groovy 
 * &#64;GrabResolver(name='thauer', 
 *   root='https://dl.dropboxusercontent.com/u/23240137/maven-repository',
 *   m2Compatible='true')
 * &#64;Grab('thauer:aws:0.1.0')
 * import net.hauers.aws.SimpleAws
 * 
 * println new SimpleAws().querySingleInstance("i-59185b19") * 
 * </pre>
 */
package net.hauers.aws;