import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SRM 465 DIV 2 500: Little Petya folding puzzle
 * @author thauer
 */
public class BoardFolding {
  public int howMany(int N, int M, String[] compressedPaper) {
    int[][] paper1 = new int[N][M];
    int[][] paper2 = new int[M][N];
    for(int i=0;i<N;i++)
      for(int j=0; j< M; j++) {
        int val = (int)(char)compressedPaper[i].charAt(j/6);
        if(48 <= val && val <=57) val -= 48;
        if(97 <= val && val <=122) val -= 87;
        if(65 <= val && val <=90) val -= 29;
        if(val==35) val = 62;
        if(val==64) val = 63;
        paper1[i][j] = ( val >> (j % 6)) % 2;        
        paper2[j][i] = ( val >> (j % 6)) % 2;        
      } 
    return howMany(paper1) * howMany(paper2);
  }
  
  private Set<List<Integer>> counter;
  private int howMany(int[][] paper) {
    
    counter = new HashSet<List<Integer>>();
    howMany(paper, 0, paper.length-1, 0, paper[0].length-1);
    return counter.size();
  }

  private void howMany(int[][] paper, int n1, int n2, int m1, int m2) {
    if(counter.contains(Arrays.asList(n1, n2, m1, m2))) return;
    counter.add(Arrays.asList(n1, n2, m1, m2));
    for(int d = m1; d <= m2-1; d++){
      if(foldsVertically(paper, n1, n2, m1, m2, d)){
        if(d <= (m1+m2-1)/2) {
          howMany(paper, n1, n2, d+1, m2);        
        }
        if(d >= (m1+m2-1)/2) {
          howMany(paper, n1, n2, m1, d);
        }
      }
    }
  }
  
  private boolean foldsVertically(int[][] paper,
      int n1, int n2, int m1, int m2, int d) {
    for(int i=n1; i<=n2; i++) {
      for(int j=1; j<=Math.min(d-m1+1, m2-d);j++) {
        if( paper[i][d-j+1] != paper[i][d+j])
          return false;
      }
    }
    return true;
  }  
}
