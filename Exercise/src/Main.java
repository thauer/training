import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {
	
	public static Random rand = new Random();

	public static void main(String[] args) {
		exerciseHeap();
	}
	
	public static void exerciseHeap() {
		PriorityQueue<Integer> large = new PriorityQueue<Integer>();
		PriorityQueue<Integer> small = new PriorityQueue<Integer>(10,new Comparator<Integer>(){
			@Override public int compare(Integer o1, Integer o2){ return o2.compareTo(o1); }
		});
		
		for(int i=0; i<101; i++) {
			Integer item = rand.nextInt(100);
			if(small.peek() == null || item < small.peek() ) {
				small.add(item);
			} else {
				large.add(item);
			}
			if(small.size() > large.size() +1 ) {
				large.add(small.poll());			
			}
			else if( large.size() > small.size() + 1 ) {
				small.add(large.poll());
			}
		}
		
		for(;!small.isEmpty();) {
			System.out.print(String.format("%5d", small.poll()));			
		}
		System.out.println();
		System.out.println();
		for(;!large.isEmpty();) {
			System.out.print(String.format("%5d", large.poll()));
		}
		System.out.println();
	}
	
	public static void exerciseHandAngle() {
		System.out.println(handAngle(3,0));
		System.out.println(handAngle(5,40));
		System.out.println(handAngle(11,59.9999));
	}
	
	public static double handAngle(double hour, double min) {
		double angleHour = hour / 12. * 360 + min / 60. / 12. * 360;
		double angleMin = min / 60. * 360;
		return angleMin - angleHour;
	}
}
