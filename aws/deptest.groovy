#!/usr/bin/env groovy 

@GrabResolver(name='thauer', root='http://bit.ly/thauer-aws-maven', m2Compatible='true')
@Grab('thauer:aws:0.1.0')
import net.hauers.aws.SimpleAws

println new SimpleAws().querySingleInstance("i-59185b19")

