import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaroCutting {
  

	/**
	 * 
	 * N and M are between 1 and 150
	 * @param height N ints between 10 and 10_000
	 * @param add N ints between 10 and 10_000
	 * @param device M ints between 10 and 10_000
	 * @param time int between 1 and 150
	 * @return
	 */
  public int oldgetNumber(final int[] height, int[] add, int[] device, int time) {
    Arrays.sort(device);
    int N = height.length;
    Set<TreeList> possibleTreeLists = new HashSet<TreeList>();
    {
      TreeList trees = new TreeList(height.length);
      for(int i=0; i<N; i++) {
        trees.add(new Tree(height[i], add[i]));
      }
      trees.print();
      possibleTreeLists.add(trees);
    }
    
    for(;time>0;time--) {
      Set<TreeList> newTreeLists = new HashSet<TreeList>();
      for(TreeList trees: possibleTreeLists) {
        System.out.println();
        trees.grow();
        Collections.sort(trees); trees.print();
        for(int t=0, d = device.length-1; d>=0 && t<trees.size(); d--) {
          if(device[d]<trees.get(t).height)
            trees.get(t).cut(device[d]);
        }
        trees.print();
        newTreeLists.add(trees);
      }
      possibleTreeLists = newTreeLists;
    }
    return 0;
	}

  private class TreeList extends ArrayList<Tree> implements List<Tree>, Comparable<TreeList>{
    
    @Override
    public boolean equals(Object o) {
      if(! (o instanceof TreeList)) return false;
      if(this.size() != ((TreeList) o).size()) return false;
      for(int i=0; i<this.size(); i++) {
        if(this.get(i).equals(((TreeList) o).get(i))) return false;
      }
      return true;
    }
    
    @Override
    public int compareTo(TreeList o) { // sizes are equal
      int compares = 0;
      for(int i=0; i<size(); i++) {
        if(this.get(i).height > o.get(i).height) {
          if(compares < 0) return 0;
          compares = 1;
        } else if(this.get(i).height < o.get(i).height) {
          if(compares > 0) return 0;
          compares = -1;
        }
      }
      return compares;
    }
    
    public TreeList(int initialsize) {
      super(initialsize);
    }
    
    public int sum() {
      int sum = 0;
      for(Tree tree:this) {
        sum += tree.height;
      }
      return sum;
    }
    
    public void grow() {
      for(Tree tree: this) {
        tree.grow();
      }
    }
    
    public void print() {
      System.out.print(" [" + this.get(0));
      for(int i=1; i<this.size(); 
          System.out.print( "," + this.get(i++))); System.out.println(" ]");    
    }
  }
  
  private class Tree implements Comparable<Tree>{
    int height;
    final int growth;
    public Tree(int height, int growth) {
      this.height = height;
      this.growth = growth;
    }
    
    public void grow() {
      height += growth;
    }
    
    public void cut(int height){
      this.height = height;
    }

    @Override
    public int compareTo(Tree o) {
      return this.height > o.height ? -1: this.height == o.height ? 0 : 1 ;
    }
    
    @Override
    public String toString() {
      return String.format("%3d (%3d)", height, growth);
    }
  }
}
