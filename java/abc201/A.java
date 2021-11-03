import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] a = new int[3];
    Arrays.setAll(a, i -> sc.nextInt());
    Arrays.sort(a);
    if (a[2] - a[1] == a[1] - a[0]) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

  }
}
