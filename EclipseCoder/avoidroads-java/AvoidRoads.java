public class AvoidRoads {

  /**
   * 
   * @param width [1, 100]
   * @param height [1, 100]
   * @param bad String[], each between 7 and 14 chars "a b c d"
   * @return
   */
  public long numWays(int width, int height, String[] bad) {
    int[][] badlink = new int[bad.length][4];
    for(int i=0; i< bad.length; i++){
      String[] nums = bad[i].split(" ");
      for(int j=0; j<4; j++)
        badlink[i][j] = Integer.parseInt(nums[j]);
    }
		
		long[][] dp = new long[width+1][height+1];
		dp[0][0] = 1;
		
		for(int i=0; i<=width; i++) {
		  for(int j=0; j<=height; j++) {
		    if(i>0 && dp[i-1][j] != 0) {
		      boolean blocked = false;
		      for(int k=0; k<badlink.length; k++) {
		        if( badlink[k][1] == j && badlink[k][3] == j && 
		            ((badlink[k][0]==i-1 && badlink[k][2]==i) ||
		            (badlink[k][0]==i && badlink[k][2]==i-1))) {
		          blocked = true;
		        }
		      }
		      dp[i][j] = blocked ? 0 : dp[i-1][j];
		    }
        if(j>0 && dp[i][j-1] != 0) {
          boolean blocked = false;
          for(int k=0; k<badlink.length; k++) {
            if( badlink[k][0] == i && badlink[k][2] == i && 
                ((badlink[k][1]==j-1 && badlink[k][3]==j) ||
                (badlink[k][1]==j && badlink[k][3]==j-1))) {
              blocked = true;
            }
          }
          dp[i][j] += blocked ? 0 : dp[i][j-1];
        }
//        System.out.println("[" + i + "," + j + "] = " + dp[i][j]);
		  }
		}
		
    return dp[width][height];
	}
}
