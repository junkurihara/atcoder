import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    if (x >= 30) {
      System.out.println("Yes");
      return;
    }
    System.out.println("No");
  }
}
