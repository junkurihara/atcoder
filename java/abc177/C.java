import java.util.*;

public class C {

  private static final long div = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] a = new long[n];
    long[] acc = new long[n];
    Arrays.setAll(a, i -> sc.nextInt());
    for (int i = n - 1; i >= 0; i--) {
      if (i == n - 1) {
        acc[i] = 0;
      } else {
        acc[i] = (acc[i + 1] + a[i + 1]) % div;
      }
    }

    // System.out.println(Arrays.toString(acc));

    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += (a[i] * acc[i]) % div;
      sum = sum % div;
    }
    System.out.println(sum);

  }

}
