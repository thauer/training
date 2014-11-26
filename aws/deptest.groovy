#!/usr/bin/env groovy 

@GrabResolver('https://dl.dropboxusercontent.com/u/23240137/maven-repository')
@GrabConfig(systemClassLoader = true)
@Grab('thauer:aws:0.1.0')
import net.hauers.aws.SimpleAws

println new SimpleAws().querySingleInstance("i-59185b19")

