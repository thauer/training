
/**
 * SRM 639 DIV 1 250
 */
public class AliceGame {
  public long findMinimumValue(long x, long y) {
    long turns = Math.round(Math.sqrt(x+y));
    if(turns*turns != x+y || x == 2 || y == 2) {
      return -1;
    } else if(x == 0) {
      return 0;
    } else if(x <= 2 * turns ) {
      return (x % 2 == 0 ? 2 : 1 );
    } else if(x == 2*turns +1){
      return 3;
    } else {
      int i=0;
      for(;x>2*turns+1;i++) {
        x -= 2*turns - 1;
        turns--;
      }
      return i + findMinimumValue(x, y);
    }
  }
}
