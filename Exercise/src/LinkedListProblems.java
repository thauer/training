
import java.util.Set;
import java.util.HashSet;

public class LinkedListProblems {
  
  public <T> void removeDuplicates(Node<T> head) {
    Set<T> set = new HashSet<>();
    set.add(head.value);
    for(Node<T> current = head; current.next != null; ) {
      if(! set.add(current.next.value)){
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
  }

  public <T> void removeDuplicates2(Node<T> head) {
    for(Node<T> master = head; master != null; master = master.next) {
      for(Node<T> current = master; current.next != null; ) {
        if(current.next.value == master.value) {
          current.next = current.next.next;
        } else {
          current = current.next;
        }
      }
    }
  }

  public static class Node<T>{
    T value;
    Node<T> next;
    
    public Node(T t){
      this.value = t;
      this.next = null;
    }
    
    public Node<T> appendToEnd(T t){
      Node<T> n = this;
      for(;n.next != null; n=n.next);
      n.next = new Node<T>(t);
      return n.next;
    }
    
    public String toString() {
      return value.toString() + (next == null ? "" : "," + next.toString());
    }
  }
  
  public <T> T lastElement(Node<T> head, int k) {

    Node<T> current = head;
    for(int i=0; i<k && current !=null; ){
      i++;
      current = current.next;
    }
    if(current == null) {
      return null;
    }
    Node<T> response = head;
    for(current = current.next; current != null; current = current.next) {
      response = response.next;
    }
    
    return response.value;
  }
  
  /**
   * All nodes smaller than pivot come before the larger ones
   */
   public <T extends Comparable<? super T>> Node<T> partition(Node<T> head, T pivot) {
     Node<T> tail = head;
     for(Node<T> current = head; current != null; ) {
       Node<T> nextnode = current.next;       
       if(current.value.compareTo(pivot) < 0 ) {
         current.next = head;
         head = current;
       } else {
         tail.next = current;
         tail = current;
         tail.next = null;
       }
       current = nextnode;
     }
     return head;
   }

  public Node<Integer> add(Node<Integer> n1, Node<Integer> n2) {
    int base = 16;
    Node<Integer> sum = null;
    Node<Integer> result = null;
    Integer carry = 0;
    for(; n1!=null || n2 != null || carry != 0 ; ) {
      Integer digitsum = (n1 == null ? 0 : n1.value) 
                       + (n2 == null ? 0 : n2.value) + carry;
      carry = digitsum > base-1 ? 1 : 0;
      digitsum -= carry * base;
      if(sum == null) {
        sum = new Node<Integer>(digitsum);
        result = sum;
      } else {
        sum.next = new Node<Integer>(digitsum);
        sum = sum.next;
      }
      n1 = (n1 == null ? null : n1.next);
      n2 = (n2 == null ? null : n2.next);
    }
    return result;
  } 

  public <T> Node<T> getLoopStart2(Node<T> head) {
    Set<Node<T>> nodes = new HashSet<Node<T>>();
    for(;head != null && ! nodes.contains(head);) {
      nodes.add(head);
      head = head.next;
    }
    return head;
  }
  
  public <T> Node<T> getLoopStart(Node<T> head) {
    Node<T> n1 = head;
    Node<T> n2 = head;

    for(; n2 != null && (n2 == head || n2 != n1);) {
      n1 = n1.next;
      n2 = n2.next == null ? null : n2.next.next;
    }
    if(n2 == null) {
      return null;
    }
    n2 = head;
    for(; n2 != n1;) {
      n1 = n1.next;
      n2 = n2.next;
    }
    return n2;    
  }
  
  public <T> boolean isPalindrom(Node<T> head) {
    Node<T> reverse = null;
    for(Node<T> n = head; n != null; n = n.next) {
      Node<T> m = new Node<T>(n.value);
      m.next = reverse;
      reverse = m;
    }
    for(; head != null;) {
      if(head.value != reverse.value) {
        return false;
      }
      head = head.next;
      reverse = reverse.next;
    }
    return true;
  }
  
  public static void main(String[] args){
    int[] list = new int[]{5,6,6,5,7};    
    Node<Integer> n0 = new Node<Integer>(7);
    for(int i:list) {
      n0.appendToEnd(i);
    }
    System.out.println(new LinkedListProblems().isPalindrom(n0));
  }
}
