
/**
 * SRM 465 DIV 2 500: Archibald turret placement
 * @author thauer
 */
public class TurretPlacement {

  public long count(int[] x, int[] y) {
    long count = 0L;
    for(int i=0; i< x.length;i++) {      
      for(int j=i+1; j<x.length; j++) {
        double dist = Math.floor( 2 * 
            Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]))) - 1;
        count += dist * (dist+1) / 2;
      }
    }
    return count;
  }
}
