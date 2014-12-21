public class ZigZag {

	public int longestZigZag(int[] sequence) {
	  int N = sequence.length;
	  
	  int[] zigup = new int[N];
	  int[] zigdown = new int[N];
	  
	  for(int i=0; i<N; i++) {
	    zigup[i]=1;
	    zigdown[i]=1;
	    for(int j=0; j<i; j++) {
	      if(sequence[j]>sequence[i] && zigdown[i] <= zigup[j]){
	        zigdown[i]=zigup[j]+1;
	      }
        if(sequence[j]<sequence[i] && zigup[i] <= zigdown[j]){
          zigup[i]=zigdown[j]+1;
        }
	    }
	  }
	  
	  int longzig = 0;
	  for(int i=0; i<N; i++) {
	    if(zigup[i]>longzig) {
	      longzig = zigup[i];
	    }
	    if(zigdown[i]>longzig) {
	      longzig = zigdown[i];
	    }
	  }
	  
		return longzig;
	}
}
