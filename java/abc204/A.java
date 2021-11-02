import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();
    if (x != y) {
      System.out.println(3 - x - y);
    } else {
      System.out.println(x);
    }
  }
}
