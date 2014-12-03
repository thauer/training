import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Exercise {
  public static void main(String[] args){
    for(int n=1; n<10; n++)
      System.out.print(String.format("%4d", fibonacci2(n)));
    System.out.println();
  }

  /**
   * Sums up the integers in a file
   */
  public static int sumIntegersFromFile(File file) {
    int sum = 0;
    try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
      for(String s; (s = reader.readLine()) != null; sum += Integer.parseInt(s));
    } catch (Exception e) {
      return -1;
    }
    return sum;
  }
  
  /**
   * Prints a multiplication table
   */
  public static void multiplicationTable() {
    for(int i=1; i<13; i++) {
      System.out.println();
      for(int j=1; j<13; j++) {
        System.out.print(String.format(" %3d", i*j));
      }
    }    
  }
  
  /**
   * Computes the nth Fibonacci number.
   * fibonacci: 0 -> 1; 1 -> 1; n -> fibonacci(n-1) + fibonacci(n-2)
   */
  public static int fibonacci(int n) {
    if( n < 0 ) {
      return -1;
    } else if ( n < 2 ) {
      return 1;
    } else {
      return fibonacci(n-1) + fibonacci(n-2);
    }
  }
  
  /**
   * Computes the nth Fibonacci number.
   * fibonacci: 0 -> 1; 1 -> 1; n -> fibonacci(n-1) + fibonacci(n-2)
   */
  public static int fibonacci2(int n) {
    return fibonacci2(0, 1, n-1);
  }

  public static int fibonacci2(int a, int b, int count) {
    return count <=0 ? b: fibonacci2(b, a+b, --count);
  }
  
  /**
   * Reverses a String
   */
  public static String reverse(String inputString){
    StringBuffer sb = new StringBuffer();

    for(int i=inputString.length()-1; i>=0; i--) {
      sb.append(inputString.charAt(i));
    }
    return sb.toString();
  }  
}