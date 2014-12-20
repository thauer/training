public class BadNeighbors {

	public int maxDonations(int[] donations) {
	  int N = donations.length;
	  int maxsum = 0;
	  for(int v=1;v>=0;v--) {
  	  int[][] dp = new int[N][N+1];
  	  
  	  dp[0][0] = v;
  	  dp[0][N] = donations[0]*v;
  	  dp[1][1] = 1;
  	  dp[1][N] = donations[1];
  	  if(N==2) return dp[1][N] > dp[0][N] ? dp[1][N] : dp[0][N];
  	  
  	  for(int i=2; i<N; i++) {
  	    int jj=0;
  	    for(int j=0; j<i-1; j++) {
  	      if(dp[j][N]>dp[i][N]) {
  	        jj=j;
  	        dp[i][N] = dp[j][N];
  	      }	      
  	    }
  	    for(int j=0; j<i-1; j++) {
  	      dp[i][j] = dp[jj][j];
  	    }
  	    dp[i][i] = 1;
  	    dp[i][N] = dp[jj][N] + donations[i];
//  	    for(int j=0; j<N+1; j++) System.out.print(", " + dp[i][j]); System.out.println(" jj=" + jj);	    
  	  }
  	  
  	  if( v==1 ) {
        if(dp[N-3][0] == 1) maxsum = dp[N-3][N];
        if(dp[N-2][N] > maxsum) maxsum = dp[N-2][N];
        if(dp[N-1][0] == 0) {
          if(dp[N-1][N] > maxsum) maxsum = dp[N-1][N];
          return maxsum;
        }
  	  } else {
  	    if(dp[N-1][N] > maxsum) maxsum = dp[N-1][N];
  	    return maxsum;
  	  }
	  }
	  return 0;
	}
}
