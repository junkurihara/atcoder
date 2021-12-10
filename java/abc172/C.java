import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    long k = sc.nextLong();
    long[] aSum = new long[n + 1];
    long[] bSum = new long[m + 1];
    for (int i = 1; i < n + 1; i++) {
      aSum[i] = aSum[i - 1] + sc.nextLong();
    }
    for (int i = 1; i < m + 1; i++) {
      bSum[i] = bSum[i - 1] + sc.nextLong();
    }

    long max = 0;
    int max_j = m;
    for (int i = 0; i < n + 1; i++) {
      if (aSum[i] > k)
        break;
      while (k - aSum[i] < bSum[max_j] && max_j > 0) {
        max_j -= 1;
      }
      max = Math.max(max, i + max_j);

    }
    System.out.println(max);
  }
}
