package net.hauers.algo

import spock.lang.*

class GraphSpec extends Specification {

  def "A graph can be created"() {
    when:
    def g = new Graph<Object,Object>()
    def v = (0..6).collect{def o = new Object(){String toString(){ return it; }}; if(it > 0) g.addVertex(o); o }

    g.addEdge(new Integer(7), v[1], v[2])
    g.addEdge(new Integer(9){ boolean equals(Object x){ return x.hashCode() == this.hashCode() }, v[1], v[3])
    g.addEdge(new Integer(14), v[1], v[6])
    g.addEdge(new Integer(10), v[2], v[3])
    g.addEdge(new Integer(15), v[2], v[4])
    g.addEdge(new Integer(11), v[3], v[4])
    g.addEdge(new Integer(2), v[3], v[6])
    g.addEdge(new Integer(6), v[4], v[5])
    g.addEdge(new Integer(9){ boolean equals(Object x){ return x.hashCode() == this.hashCode() }, v[5], v[6])

    g.dijkstra(v[1],v[5])
    then:
    true
  }
}
