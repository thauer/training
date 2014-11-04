package net.hauers.greeting

import spock.lang.Specification
import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import groovy.json.JsonSlurper

class GreetingControllerSpec extends Specification {

  def "Unit test without spring: The greeting() method greets null" () {
    given: "A GreetingController instance"
    def controller = new GreetingController()

    when: "Calling the greeting() method"
    def greeting = controller.greeting()

    then: "The string 'Hello, null!' is returned"
    greeting.content == "Hello, null!"

    when: "Calling greeting() again"
    greeting = controller.greeting()

    then: "The id is incremented"
    greeting.id == old(greeting.id) + 1
  }

  def "Unit test without spring: The greeting() method greets the parameter passed" () {
    given: "A GreetingController instance"
    def controller = new GreetingController()

    when: "Calling the greeting() method with a name argument"
    def greeting = controller.greeting("Joe Doe")

    then: "The string 'Hello, Joe Doe!' is returned"
    greeting.content == "Hello, Joe Doe!"
  }

  MockMvc mockMvc

  def setup() {
    mockMvc = standaloneSetup(new GreetingController()).build()
  }

  def "Spring-powered controller greets World"() {

    when: "Calling the controller without argument"
    def response = mockMvc.perform(get("/greeting"))

    then: "An OK response is received with json content"
    response.andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))

    and: "World is greeted with id 1"
    def jsonResponse = new JsonSlurper().parseText(response.andReturn().response.contentAsString)
    jsonResponse.id == 1
    jsonResponse.content == "Hello, World!"
  }

  def "Spring-powered controller greets the passed name parameter"() {

    when: "Calling the controller without argument"
    def response = mockMvc.perform(get("/greeting?name=${name}"))

    then: "An OK response is received with json content"
    response.andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))

    and: "The passed on name is greeted with id 1"
    def jsonResponse = new JsonSlurper().parseText(response.andReturn().response.contentAsString)
    jsonResponse.id == 1
    jsonResponse.content == "Hello, ${name}!"

    where: "The name parameter takes various values"
    name << ["Tamas", "Judit", "Bence Hauer", "Of course, baby"]
  }
}