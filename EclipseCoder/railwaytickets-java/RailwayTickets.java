import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * SRM 348 DIV 1 - 500 
 */
public class RailwayTickets {
	public int minRejects(String[] travel, int seats) {

	  List<Segment> segments = new ArrayList<Segment>();
	  for(String travelElement: travel) {
	    for(String s: travelElement.split(" ")){
	      segments.add(new Segment(s));
	    }
	  }
	  Collections.sort(segments, 
	      new Comparator<Segment>(){
	        @Override
	        public int compare(Segment s1, Segment s2) {return s1.end.compareTo(s2.end);}
        }
	  );
    // At most 600 (50 * 12) segments.
    return minRejects(segments, seats);
	}
	
	private int minRejects(List<Segment> segments, int seats)
	{
	  SortedSet<Segment> running = new TreeSet<Segment>();
	  int reject = 0;
	      
	  for(Segment nextSegment: segments){
	    Iterator<Segment> runiter=running.iterator();
	    boolean found = false;
      for(; ! found && runiter.hasNext();){
        found = (nextSegment.start >= runiter.next().end);
      }
      if(found) {
        runiter.remove();
        running.add(nextSegment);        
      } else {
        if(running.size() < seats){
          running.add(nextSegment);
        } else {
          reject++;
        }
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
    public int compareTo(Segment o) {
      return this.end.compareTo(o.end) == 0 ? 1: -this.end.compareTo(o.end);
    }
	}
}

