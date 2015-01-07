
public class StackQueueProblems {

  public static class Node<T>{
    T value;
    T min = null;
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
  
  public static class Stack<T extends Comparable<? super T>> {
    
    Node<T> head = null;
    
    public void push(T t) {      
      Node<T> newnode = new Node<T>(t);
      if(head==null) {
        newnode.min = t;
      } else {
        newnode.min = head.min.compareTo(t) > 0 ? t : head.min; 
      }
      newnode.next = head;
      head = newnode;
    }
    
    public T pop() {
      if(head == null) {
        return null;
      }
      T value = head.value;
      head = head.next;
      return value;
    }
    
    public String toString() {
      return head == null ? null : head.toString();
    }
    
    public T getMin() {
      return head == null ? null : head.min;
    }
  }
  
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    int[] list = new int[]{1,2,3,0,4,5};
    for(int i:list) {
      stack.push(i);
    }
    
    stack.pop();System.out.println(stack.getMin());
    stack.pop();System.out.println(stack.getMin());
    stack.pop();System.out.println(stack.getMin());
    stack.pop();System.out.println(stack.getMin());
    stack.pop();System.out.println(stack.getMin());
    stack.pop();System.out.println(stack.getMin());
    stack.pop();System.out.println(stack.getMin());
    
    System.out.println(stack.toString());
    
  }
}
