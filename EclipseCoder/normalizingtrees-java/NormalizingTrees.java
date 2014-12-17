import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NormalizingTrees {

  public int[] normalize(int[] tree) {    
//    printme(tree);
    int[] goodtree = new int[tree.length];
    
    Set<Integer> roots = findRoots(tree);
    
    for(int root:roots) {
      int[] newtree = setRoot(tree, root);
      sort(newtree);
      for(int i=0;i<tree.length;i++) {
        if(newtree[i]<goodtree[i]){
          goodtree=newtree; break;
        }
      }      
    }
    return goodtree;
  }

  private int compare(int[] tree, int m, int n) {
    List<Integer> mchildren = new ArrayList<Integer>();
    List<Integer> nchildren = new ArrayList<Integer>();
    for(int i=0; i<tree.length; i++) {
      if(tree[i]==m) mchildren.add(i);
      if(tree[i]==n) nchildren.add(i);
    }
    if(mchildren.size() > nchildren.size()) return -1;
    if(mchildren.size() < nchildren.size()) return +1;
    for(int i=0; i<mchildren.size();i++){
      int comp = compare(tree, mchildren.get(i), nchildren.get(i));
      if( comp != 0 ) return comp;
    }
    return 0;
  }  
  
	private void sort(int[] tree) {
    for(boolean found=true; found==true;) {
      found = false;
//      printme(tree);
      
      for(int i=1; !found && i<tree.length; i++) {
        if(tree[i-1]>tree[i]){
          found = true;
          swap(tree, i-1, i);
        }
      }
      
      for(int i=tree.length-2; !found && i>=0;i--) {
        if(tree[i]==tree[i+1] && compare(tree,i,i+1)>0) {
          found = true;
          swap(tree, i, i+1);
        }
      }      
    }
	}
	
	private void swap(int[] tree, int m, int n) {
	  int tmp = tree[m];
	  for(int i=0; i < tree.length; i++) {
	    if(i != m && i != n) {
	      tree[i] = tree[i] == m ? n : tree[i] == n ? m: tree[i];
	    }
	  }
	  tree[m] = tree[n]!=m ? tree[n] : n; 
	  tree[n] = tmp!=n ? tmp : m;
	}
	
  private Set<Integer> findRoots(int[] tree) {
    int[] neighbors = new int[tree.length];
    for(int i=0; i<tree.length; i++) {
      if(tree[i]>-1) {
        neighbors[tree[i]]++;
        neighbors[i]++;
      }
    }

    int max = Integer.MIN_VALUE;
    for(int i=0; i<tree.length; i++){
      if(neighbors[i]>max){
        max = neighbors[i];
      }
    }
    
    Set<Integer> roots = new HashSet<Integer>();
    for(int i=0; i<tree.length; i++){
      if(neighbors[i]==max){
        roots.add(i);
      }
    }
    return roots;
  }

  private int[] setRoot(int[] tree, int root) {
    int[] newtree = new int[tree.length];
    Arrays.fill(newtree, -2);
    newtree[root] = -1;
    for(int r = root;tree[r] != -1;) {
      newtree[tree[r]] = r; r = tree[r];
    }
    for(int i=0; i<tree.length; i++){
      if(newtree[i]==-2){
        newtree[i] = tree[i];
      }
    }
    return newtree;
  }
  
	private void printme(int[] array) {
    System.out.print(String.format("[ %3d",array[0]));
	  for(int i=1;i<array.length; System.out.print(String.format(",%3d", array[i++])));
	  System.out.println(" ]");
//    System.out.print(String.format("[ %3d",0));
//    for(int i=1;i<array.length; System.out.print(String.format(",%3d", i++)));
//    System.out.println(" ]");	  
	}
}
