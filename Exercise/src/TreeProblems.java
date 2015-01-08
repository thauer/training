
import java.util.Set;
import java.util.HashSet;

public class TreeProblems {
  
  public static void main(String[] args) {
    BNode<Integer> x = new BNode<Integer>(12);
    System.out.println(x);
  }
  
  public static class BNode<E> {
    
    BNode<E> left;
    BNode<E> right;
    E value;

    public BNode(E value) {
      this(null, null, value);
    }
    
    public BNode(BNode<E> left, BNode<E> right, E value) {
      this.left = left;
      this.right = right;
    }    
    
    public BNode<E> getLeft() {
      return left;
    }
    
    public BNode<E> getRight() {
      return right;
    }
    
    public boolean isBalanced() {
      if(left == null && right == null) {
        return true;
      } else if(left == null) {
        return right.depth() == 1;
      } else if(right == null) {
        return left.depth() == 1;
      }
      return left.isBalanced() && right.isBalanced() && left.depth() - right.depth() > -2 && left.depth() - right.depth() < -2;
    }
    
    public int depth() {
      if(left == null && right == null) {
        return 0;
      } else if (left == null) {
        return right.depth() +1;        
      } else if (right == null) {
        return left.depth() + 1;
      } else {
        return Math.max(left.depth(), right.depth());
      }
    }
  }
}
