import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.Random;

public class Sort {

	public static void main(String[] args){
		System.out.println("Hello, world");
		Integer[] arr = {6,32,87,3,75,4,4,10}; 
		Vector<Integer> vect = new Vector<Integer>(Arrays.asList(arr));
		quickSort(vect);
		System.out.println();
		for(Integer i: vect){
			System.out.print(" " + i);
		}
	}
	
	public static <T extends Comparable<? super T>> void quickSort(final List<T> listToSort, int start, int end) {
		int pick = new Random().nextInt(end+1-start) + start;
		swap(listToSort, pick, end);
		T pivot = listToSort.get(end);
		System.out.print( " " + pivot );
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
	
	public static <T extends Comparable<? super T>> void quickSort(final List<T> listToSort) {
		quickSort(listToSort, 0, listToSort.size()-1);
	}	
}
