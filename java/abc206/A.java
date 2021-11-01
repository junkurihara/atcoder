import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    double price = Math.floor(1.08 * (double) N);
    if (price > 206.0) {
      System.out.println(":(");
    } else if (price == 206) {
      System.out.println("so-so");
    } else {
      System.out.println("Yay!");
    }
  }

}
