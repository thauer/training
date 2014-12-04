import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class RailwayTickets {

	public int minRejects(String[] travel, int seats) {

	  List<Segment> segments = new ArrayList<Segment>();
	  for(String travelElement: travel) {
	    for(String s: travelElement.split(" ")){
	      segments.add(new Segment(s));
	    }
	  }
	  Collections.sort(segments, new Comparator<Segment>(){
	    @Override
	    public int compare(Segment s1, Segment s2) {return s1.end.compareTo(s2.end);}}
	  );
	  System.out.print("Segments (" + segments.size() + "):");
	  for(Segment segment: segments) System.out.print(" " + segment);
    System.out.println("\nSeats: " + seats);
    // At most 600 (50 * 12) segments.
    return minRejects(segments, seats);
	}
	
	private int minRejects(List<Segment> segments, int seats)
	{
	  SortedSet<Segment> running = new TreeSet<Segment>();
	  
	  for(Iterator<Segment> segiter = segments.iterator(); segiter.hasNext(); ) {
	    Segment nextSegment = segiter.next();
	    if(running.size()<seats){
	      running.add(nextSegment);
	    } else {
	      Iterator<Segment> runiter=running.iterator();
	      for(; runiter.hasNext() && runiter.next().compareTo(nextSegment) < 0; );
        runiter.remove();
        running.add(nextSegment);
	    }
	  }
	  
    Segment[] current = new Segment[seats];
    for(int i=0; i<seats; current[i]=new Segment("0-0"));
    
    int reject = 0;
    
    for(Segment nextSegment: segments) {
      
      for(Iterator<Segment> runningIter = running.iterator(); runningIter.hasNext(); ) {
        if(runningIter.next().end<=nextSegment.start) {
          runningIter.remove();
        }
      }
      for(Segment segment: running) System.out.print(" " + segment); System.out.println();
      if(running.size()<seats) { 
        running.add(nextSegment);
      } else {
        reject++;
      }
    }    
		return reject;
	}
	
	private class Segment implements Comparable<Segment>{
	  public Integer start;
	  public Integer end;
	  public Segment(String s) {
	    String[] endpoints = s.split("-");
	    start = Integer.parseInt(endpoints[0]);
	    end = Integer.parseInt(endpoints[1]);
	  }
	  @Override
	  public String toString(){
	    return "" + start + "-" + end;
	  }
    @Override
    public int compareTo(Segment o) {
      return -this.end.compareTo(o.end);
    }
	}
}

