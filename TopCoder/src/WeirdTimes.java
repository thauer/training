
public class WeirdTimes {
	
	public int[] hourValues(int[] minuteValues, int K) {
	  
    int[] hour = new int[minuteValues.length];
    boolean[] solution = new boolean[minuteValues.length];
    for(int i=0; i<minuteValues.length; hour[i++] = -1);
	  
	  for(int ptr = 0; K>0 && ptr >= 0; ) {
  	  if(hour[ptr] == -1) { // we got here from below, need to fill it
        solution[ptr] = false;
  	    if(ptr==0) {
  	      hour[ptr++] = 0;
  	    }
  	    else if(minuteValues[ptr] > minuteValues[ptr-1]) {
  	      hour[ptr] = hour[ptr-1];
  	      ptr++;
  	    }
  	    else if(hour[ptr-1] < 23){
          hour[ptr] = hour[ptr-1] + 1;
          ptr++;
  	    } else {
  	      ptr--;
  	    }
  	  } else { // we got here from above, need to increment or clear
  	    if(hour[ptr] < 23 && solution[ptr]) {
  	      hour[ptr] ++;
  	      ptr ++;
  	    } else {
  	      hour[ptr--] = -1;
  	    }
  	  }
  	  if(ptr == minuteValues.length) {
  	    for(int i=0; i<minuteValues.length; solution[i++] = true);
  	    K--;
  	    ptr--;
  	  }
	  }
	  if(K>0) return new int[]{-1};
	  return hour;
	}
}
