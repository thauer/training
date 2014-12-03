import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SRM 465 DIV 2 250: Archibald neighboring pairs
 * 
 * @author thauer
 *     
 * The celebrated general Archibald Waving took charge of the second army in the 
 * occidental front. After losing the first army, Waving has become obsessed with 
 * effective organization of the army. As a part of this endeavor he has assigned 
 * numbers to each of his soldiers. He has also devised a rule which allows two 
 * soldiers to work together if and only if the numbers assigned to the soldiers 
 * are neighbouring numbers. Two numbers x and y are neighbouring numbers if there 
 * exists a permutation of digits of x and a permutation of digits of y such that 
 * they are equal if we ignore the leading zeros in the permutations. For example, 
 * the numbers 40020 and 204 are neighboring. To see this, permute the digits of 
 * 40020 to achieve 00042 and the digits of 204 to achieve 042. If you ignore the 
 * leading zeros, both numbers become equal to 42, so they are neighboring.
 *
 * You are given a int[] numbers representing soldiers' numbers. Waving needs to 
 * pick two soldiers to send a telegram. He would like to know how many different 
 * pairs of soldiers are there who can work together to accomplish the task. Help 
 * Waving by returning the number of pairs of neighbouring numbers in the int[] 
 * numbers.
 */
public class NumberNeighbours {
	
  /**
   * 
   * @param numbers: contains between 2 and 50 elements, inclusive, Each element 
   * is between 1 and 1,000,000, inclusive, all elements of numbers are distinct.
   * @return The number of possible pairs of neighboring soldiers
   */
	public int numPairs(int[] numbers) {
	  
	  Map<Integer, Integer> multiplicity = new HashMap<Integer, Integer>();
	  for(int i:numbers) {
	    Integer canonical = canonicalForm(i);
	    Integer thismul = multiplicity.get(canonical);
	    thismul = thismul == null ? 1 : thismul + 1;
      multiplicity.put(canonical, thismul);
	  }
	  
	  int pairs = 0;
	  
	  for(Integer multi: multiplicity.values()) {
	    pairs += multi*(multi-1)/2;
	  }
	  
		return pairs;
	}
	
	private int canonicalForm(int number) {
	  List<Integer> digits = new ArrayList<Integer>();
	  for(; number > 0; number /= 10){
	    digits.add(number % 10);
	  }
	  Collections.sort(digits);
	  for(Integer i:digits){
	    if(i> 0){
	      number = 10 * (number + i);
	    }
	  }
	  return number;
	}	
}
