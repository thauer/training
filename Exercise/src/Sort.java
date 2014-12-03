import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.Random;

public class Sort {

	public static void main(String[] args) {
		testSort();
	}
	
	public static void testSort(){
		Integer[] arr = {6,32,87,3,75,4,4,10}; 
		List<Integer> vect = new Vector<Integer>(Arrays.asList(arr));
		List<Integer> list = new Vector<Integer>(Arrays.asList(arr));
		quickSort(vect);
		System.out.println();
		for(Integer i: vect) System.out.print(" " + i);
		System.out.println();
		for(Integer i: mergeSort(list)) System.out.print(" " + i);
	}
	
	/**
	 * quickSort
	 */
	public static <T extends Comparable<? super T>> void quickSort(final List<T> listToSort) {
		quickSort(listToSort, 0, listToSort.size()-1);
	}
	
	public static <T extends Comparable<? super T>> void quickSort(final List<T> listToSort, int start, int end) {
		int pick = new Random().nextInt(end+1-start) + start;
		swap(listToSort, pick, end);
		T pivot = listToSort.get(end);
		int j = start;
		for(int i=start; i <= end; i++ ) {
			if( listToSort.get(i).compareTo(pivot) <= 0 ){
				swap(listToSort, i, j++);
			}			
		}
		if(j-2 > start)
			quickSort(listToSort, start, j-2);
		if(j < end)
			quickSort(listToSort, j, end);
	}
	
	public static <T extends Comparable<? super T>> void swap(final List<T> listToSort, int i, int j){
		T tmp = listToSort.get(i);
		listToSort.set(i, listToSort.get(j));
		listToSort.set(j, tmp);
	}
	
	/**
	 * mergeSort
	 */
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
