
public class Node {

  int i;
  Node next = null;
    
  public Node(int i) {
    this.i = i;
  }
  
  public void appendToTail(int i) {
    Node n = this;
    for(; n.next !=null; n=n.next)
    n.next = new Node(i);
  }
}
