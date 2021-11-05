import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    Arrays.setAll(a, i -> sc.nextInt());
    Arrays.setAll(b, i -> sc.nextInt());

    var max_a = a[0];
    var min_b = b[0];
    for (int i = 1; i < n; i++) {
      max_a = Math.max(max_a, a[i]);
      min_b = Math.min(min_b, b[i]);
    }
    if (max_a > min_b) {
      System.out.println(0);
    } else {
      System.out.println(min_b - max_a + 1);
    }
  }
}
