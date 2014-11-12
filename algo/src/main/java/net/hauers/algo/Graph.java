package net.hauers.algo;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;

/**
  * A graph contains objects of type V at the vertices and objects of type E at the edges
  * Can add a vertex to a graph
  * Can add an edge to a graph but it has to end on existing vertices
  */
public class Graph<V,E> {

  private Set<V> vertices = new HashSet<V>();
  private Map<V,Set<E>> vertextoedge = new HashMap<V, Set<E>>();
  private Map<E,Set<V>> edgetovertex = new HashMap<E, Set<V>>();

  public void addVertex(V vertex) {
    vertices.add(vertex);
    vertextoedge.put(vertex, new HashSet<E>());
  }

  public void addEdge(E edge, V v1, V v2) {
    assert vertices.contains(v1);
    assert vertices.contains(v2);
    vertextoedge.get(v1).add(edge);
    vertextoedge.get(v2).add(edge);
    edgetovertex.put(edge, new HashSet<V>(Arrays.asList(v1, v2)));
  }

  public Set<E> getEdges(V vertex) {
    return edgetovertex.keySet();
  }

  public Set<V> getVertices(E edge) {
    return vertices;
  }

  public V getNeighbor(V vertex, E edge) {
    for(V v: edgetovertex.get(edge)) {
      if(v!=vertex){
        return v;
      }
    }
    return null;
  }

  public List<V> dijkstra(V vinitial, V vfinal){

    // 1. Assign to every node a tentative distance value: set it to zero for our initial node 
    // and to infinity for all other nodes.
    Map<V, Integer> distance = new HashMap<V, Integer>();
    for(V v: vertices) {
      distance.put(v, Integer.MAX_VALUE);
    }
    distance.put(vinitial, 0);

    // 2. Mark all nodes unvisited. Set the initial node as current. Create a set of the unvisited 
    // nodes called the unvisited set consisting of all the nodes.

    Set<V> unvisited = new HashSet<V>(vertices);
    V current = vinitial;

    for(;unvisited.contains(vfinal);) {
      System.out.println("Current is: " + current);

      // 3. For the current node, consider all of its unvisited neighbors and calculate their tentative 
      // distances. Compare the newly calculated tentative distance to the current assigned value and 
      // assign the smaller one. For example, if the current node A is marked with a distance of 6, 
      // and the edge connecting it with a neighbor B has length 2, then the distance to B (through A) 
      // will be 6 + 2 = 8. If B was previously marked with a distance greater than 8 then change 
      // it to 8. Otherwise, keep the current value.

      unvisited.remove(current);
      int currentDistance = distance.get(current);
      System.out.println("Current distance is: " + currentDistance);
      int nextDistance = Integer.MAX_VALUE;
      V next = null;
      for(E edge: vertextoedge.get(current)) {
        System.out.println("   Edge is: " + edge);
        V neighbor = getNeighbor(current, edge);
        if(unvisited.contains(neighbor)) {
          System.out.println("   Neighbor is: " + neighbor);
          int throughCurrent = currentDistance + (Integer) edge;
          System.out.println("   Distance: " + distance.get(neighbor) + " Through distance: " + throughCurrent);
          if(throughCurrent < distance.get(neighbor)) {
            distance.put(neighbor, throughCurrent);
          }
          if(distance.get(neighbor) < nextDistance) {
            nextDistance = distance.get(neighbor);
            next = neighbor;
          }
        }
      }
      current = next;

      // 4. When we are done considering all of the neighbors of the current node, mark the current 
      // node as visited and remove it from the unvisited set. A visited node will never be checked again.

      // 5. If the destination node has been marked visited (when planning a route between two 
      // specific nodes) or if the smallest tentative distance among the nodes in the unvisited set is 
      // infinity (when planning a complete traversal; occurs when there is no connection between the 
      // initial node and remaining unvisited nodes), then stop. The algorithm has finished.


      // 6. Select the unvisited node that is marked with the smallest tentative distance, 
      // and set it as the new "current node" then go back to step 3.
    }


    return null;
  }
}