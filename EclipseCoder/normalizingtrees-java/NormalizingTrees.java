import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NormalizingTrees {

	public int[] normalize(int[] tree) {	  
	  printme(tree);	  
    int[] goodtree = new int[tree.length];
    
	  Set<Integer> roots = findRoots(tree);
	  
	  for(int root:roots) {
	    int[] newtree = setRoot(tree, root);
	    
      for(boolean found=true; found==true;) {
        found = false;
        printme(newtree);
        for(int i=1; !found && i<tree.length; i++) {
          if(newtree[i]<newtree[i-1]){
            found = true;
            swap(newtree, i-1, i);
          }
        }        
        
        for(int i=1; !found && i<tree.length; i++) {
          if(newtree[i]>newtree[i-1]+1&&
              newtree[newtree[i]]==newtree[newtree[i]-1]){
            found = true;
            swap(newtree, newtree[i], newtree[i]-1);
          }
        }
        
        for(int prevcount=1, count=1, i=1; !found && i<=tree.length; i++) {
          if(i<tree.length && newtree[i]==newtree[i-1]){
            count ++;
          } else {
            if(count>prevcount && newtree[i-1]-1 > -1 && 
                swapIfEqual(newtree,newtree[i-1], newtree[i-1]-1)) {              
              found = true;
            } else {
              prevcount = count;
              count = 1;
            }
          }
        }        
      }
      
      for(int i=0;i<tree.length;i++) {
        if(newtree[i]<goodtree[i]){
          goodtree=newtree; break;
        }
      }      
	  }
		return goodtree;
	}

	private boolean swapIfEqual(int[] tree, int m, int n) {
	  System.out.println("trying to swap " + m + " " +n);
	  if(tree[m]==tree[n] && (m==n+1 || n==m+1)) {
	    System.out.println("Swapping " + m + " " +n);
	    swap(tree, m, n);
	    return true;
	  }
	  int countn=0, countm=0;
	  for(int i=0; i<tree.length; i++) {
	    if(tree[i]==tree[m]){
	      countm++;
	    }
      if(tree[i]==tree[n]){
        countn++;
      }
	  }
	  if(countn==countm) {
	    return swapIfEqual(tree,tree[m], tree[n]);
	  }	  
	  return false;
	}
  /**
   * 
   */	
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
	
  /**
   * 
   */
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

  /**
   * 
   */
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
	  System.out.print("[ " + array[0]);
	  for(int i=1;i<array.length; System.out.print(", " + array[i++]));
	  System.out.println(" ]");
	}
}
