
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class Interview {
  
  /**
    *  
    */
  public void removeDuplicates() {
    
  }
  
  public static class Node<T>{
    T t;
    Node<T> next;
    
    public Node(T t){
      this.t = t;
      this.next = null;
    }
    
    public void appendToEnd(T t){
      Node<T> n = this;
      for(;n.next != null; n=n.next);
      n.next = new Node<T>(t);
    }
    
    public String toString() {
      return t.toString() + (next == null ? "" : "," + next.toString());
    }
  }
  
  public static void main(String[] args){
    Node<Integer> n0 = new Node<Integer>(7);
    n0.appendToEnd(6);
    n0.appendToEnd(9);
    
    System.out.println(n0);
  }
}
