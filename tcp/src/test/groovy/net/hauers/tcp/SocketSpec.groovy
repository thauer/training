package net.hauers.tcp

import spock.lang.*

class SocketSpec extends Specification {

  def "It's a wonderful world"() {
    expect: 
    true
  }

  def "Can send something"() {
    /* This test assumes that there is an echo server running on 
     * port 2000. Start one with 
     * 'ncat -l 2000 --keep-open --exec "/bin/cat"' beforehand.
     */
    
    given: "A UdpClient instance"
    def client = new UdpClient()

    when: "Calling sendAndReceive()"
    def received = client.sendAndReceive(sent)

    then: "The return is what we had sent"
    received.equals(sent)

    where:
    sent << ["Hello"]
  }
}