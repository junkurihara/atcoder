import java.util.*;

public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final long div = 998244353;

    int n = sc.nextInt();
    int k = sc.nextInt();
    var hs = new ArrayList<Integer>();
    for (int i = 0; i < k; i++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      for (int j = l; j < r + 1; j++) {
        hs.add(j);
      }
    }
    var min = hs.stream().mapToInt(x -> (int) x).min().getAsInt();
    long[] dp = new long[n];

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        dp[i] = 1;
      }
      if (i + min < n) {
        for (int x : hs) {
          if (i + x < n) {
            dp[i + x] = (dp[i] + dp[i + x]) % div;
          }
        }
      }
    }
    System.out.println(dp[n - 1]);
  }

}
