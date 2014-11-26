/**
  * A program to reverse a string
  */

public class ReverseString {

  public static void main(String[] args) {
    String[] test = {"987654321"};

    for(String t: test) {
      System.out.println(reverse(t));
    }
  }

  public static String reverse(String inputString){
    StringBuffer sb = new StringBuffer();

    for(int i=inputString.length()-1; i>=0; i--) {
      sb.append(inputString.charAt(i));
    }
    return sb.toString();
  }
}