
public class AliceGame {

  public long findMinimumValue(long x, long y) {
    long turns = Math.round(Math.sqrt(x+y));
    System.out.println(turns);
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
/* 
 * 2,000,001| 999,997,999,999 | should: 3 (we are returning: 2)
 * 10 ^ 12 = 1,000,000,000,000
 * turns = 1,000,000
 * turns - sqrt(y) = 1.000001 
 * return 1 + 1 = 2
 * 
 * 
 * x = 1,000,000,000,000 | y = 0 | should: 1,000,000
 * instead, we are returning 1,000,002
 * turns = 1,000,000, returning 1,000,000 + 2
 */
