import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    Arrays.setAll(a, i -> sc.nextInt());
    int acc = 0;
    for (int i = 0; i < n; i++) {
      acc += a[i] - Math.min(10, a[i]);
    }
    System.out.println(acc);
  }
}
