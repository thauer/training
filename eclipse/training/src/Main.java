import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int[] ns = {10, 100, 1000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000 };
		for(int n:ns) {
			List<Integer> listToSort = new ArrayList<Integer>();
			for(int i=0; i< n; i++) {
				listToSort.add(rand.nextInt(100));
			}
			
			long t = System.currentTimeMillis();
			mergeSort(listToSort);
//			for(Integer i: mergeSort(listToSort)) System.out.print(" " + i); System.out.println();
			long time = System.currentTimeMillis()-t;
			System.out.println("" + n + " : " + time + "-----" + (n * Math.log(n))/time);			
		}
	}
	
	public static <T extends Comparable<? super T>> List<T> mergeSort(List<T> listToSort){
		
		if(listToSort.size() < 2) {
			return listToSort;
		}
		int mid = listToSort.size() / 2; 
		List<T> left = listToSort.subList(0, mid);
		List<T> right = listToSort.subList(mid, listToSort.size());
		
		return merge(mergeSort(left), mergeSort(right));
	}
	
	public static <T extends Comparable<? super T>> List<T> merge(List<T> l1, List<T> l2){
		
		List<T> merged = new ArrayList<T>();		
		Iterator<T> i1 = l1.iterator(), i2=l2.iterator();
		
		for(T x1 = i1.next(), x2 = i2.next(); x1 != null || x2 != null;) {
			if( x1 == null || (x2 != null && x1.compareTo(x2) > 0)) {
				merged.add(x2);
				x2 = i2.hasNext() ? i2.next() : null;
			} else {
				merged.add(x1);
				x1 = i1.hasNext() ? i1.next() : null;
			}
		}
		
		return merged;
	}
}
