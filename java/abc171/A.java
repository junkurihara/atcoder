import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String alpha = sc.next();
    if (alpha.equals(alpha.toLowerCase())) {
      System.out.println("a");
      return;
    }
    System.out.println("A");
  }
}
