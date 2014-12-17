import java.util.HashMap;
import java.util.Map;

public class WaitingForBus {

  public double whenWillBusArrive(int[] time, int[] prob, int s) {
    
    Map<Integer, Double> waitingTime = new HashMap<Integer, Double>();
    waitingTime.put(0, 0.0);
    for(int t=1; t<=s; t++) {      
      double wait = 0;
      for(int i=0; i<time.length; i++) {
        wait += ( t > time[i] ? waitingTime.get(t-time[i]) : time[i]-t ) * prob[i] / 100;
      }
      waitingTime.put(t, wait);
    }            
    return waitingTime.get(s);
  }
}
