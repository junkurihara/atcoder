import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int s = sc.nextInt();
    int t = sc.nextInt();
    int x = sc.nextInt();

    t = (t < s) ? t + 24 : t;
    x = (x < s) ? x + 24 : x;
    if (x < t && x >= s) {
      System.out.println("Yes");
      return;
    }
    System.out.println("No");

  }
}
