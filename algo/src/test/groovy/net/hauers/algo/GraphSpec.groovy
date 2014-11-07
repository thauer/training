package net.hauers.algo

import spock.lang.*

class GraphSpec extends Specification {

  def "A graph can be created"() {
    when:
    def v1 = new Vertex();
    def v2 = new Vertex([v1], [7]);
    def v3 = new Vertex([v1, v2], [9, 10]);
    def v4 = new Vertex([v2, v3], [15, 11]);
    def v5 = new Vertex([v4],[6]);
    def v6 = new Vertex([v1, v3, v5],[14, 2, 9]);

    then:
    [v2,v3,v6].every{it in v1.neighbors}
  }
}
