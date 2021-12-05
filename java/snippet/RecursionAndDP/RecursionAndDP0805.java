import java.util.*;

public class RecursionAndDP0805 {
  public static void main(String[] args) {
    int a = 13;
    int b = 13;
    int prod = minProduct(a, b);
    System.out.println(prod);
  }

  static int minProduct(int a, int b) {
    int bigger = a < b ? b : a;
    int smaller = a > b ? b : a;
    // int memo[] = new int[smaller + 1];
    return minProductHelper(smaller, bigger);// , memo);
  }

  static int minProductHelper(int smaller, int bigger) {// , int[] memo) {
    if (smaller == 0) {
      return 0;
    } else if (smaller == 1) {
      return bigger;
    } // else if (memo[smaller] > 0) {
      // return memo[smaller];
    // }

    int s = smaller >> 1;
    int side1 = minProductHelper(s, bigger); // , memo);
    // int side2 = side1;
    if ((smaller & 0x1) == 1) {
      return side1 + side1 + bigger;
      // side2 = minProductHelper(smaller - s, bigger, memo);
    }
    return side1 + side1;
    // memo[smaller] = side1 + side2;
    // return memo[smaller];
  }
}
