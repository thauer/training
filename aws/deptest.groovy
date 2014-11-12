#!/usr/bin/env groovy 

@GrabResolver(name='thauer', root='https://dl.dropboxusercontent.com/u/23240137/maven-repository', m2Compatible='true')
@Grab('thauer:aws:0.1.0')
import net.hauers.aws.SimpleAws

println new SimpleAws().querySingleInstance("i-28b188cd")

