import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();

    if (Math.abs(x - y) < 3) {
      System.out.println("Yes");
      return;
    }
    System.out.println("No");

  }
}
