import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] a = new long[n];
    Arrays.setAll(a, i -> sc.nextLong());

    long sum = 0;
    int ptr = 0;

    for (int i = 1; i < n; i++) {
      if (a[ptr] <= a[i]) {
        ptr = i;
      } else {
        sum += a[ptr] - a[i];
      }
    }
    System.out.println(sum);
  }
}
