import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FlowerGarden {

  /**
   * @param height how high the flower type grows
   * @param bloom morning the flower springs from ground [1,365]
   * @param wilt evening when flower dies [1,365], > bloom
   * @return
   */
  public int[] getOrdering(final int[] height, int[] bloom, int[] wilt) {
    
    int N = height.length;
        
    int[][] conflict = new int[N][N];
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        if((bloom[i]<=bloom[j] && bloom[j]<=wilt[i]) || 
           (bloom[j]<=bloom[i] && bloom[i]<=wilt[j]) ) {
          conflict[i][j] = 1;
        }
      }      
    }

    List<Integer> flowers = new ArrayList<Integer>(N);
    for(int i=0; i<N; flowers.add(i++));
    Collections.sort(flowers, new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2) {        
        return height[o1]>height[o2] ? 1 : height[o1]<height[o2] ? -1 : 0;
      }
    });
    
//    for(Integer i: flowers) { System.out.print(", " + height[i]);}System.out.println();System.out.println();
    
    List<Integer> garden = new ArrayList<Integer>(N);
    garden.add(flowers.get(0));
    for(int i=1; i<N; i++) {
      int f = flowers.get(i);
      int j=0;
      for(; j<garden.size() && conflict[f][garden.get(j)] == 0; j++);
      if(j<garden.size()){
        garden.add(j, f);
      } else {
        garden.add(f);
      }
//      for(Integer ii: garden) { System.out.print(", " + height[ii]);}System.out.println();
    }
    int[] gardenarray = new int[N];
    for(int i=0; i<N; i++) {
      gardenarray[i] = height[garden.get(N-1-i)]; 
    }
    return gardenarray;
	}
}
