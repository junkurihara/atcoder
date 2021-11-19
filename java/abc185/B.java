import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int t = sc.nextInt();
    int[][] ab = new int[m][2];
    Arrays.setAll(ab, i -> {
      int[] l = new int[2];
      Arrays.setAll(l, j -> sc.nextInt());
      return l;
    });

    int current = n;
    for (int i = 0; i < m; i++) {
      current -= (i > 0) ? (ab[i][0] - ab[i - 1][1]) : ab[i][0];
      if (current <= 0) {
        System.out.println("No");
        return;
      }
      current = Math.min(n, current + ab[i][1] - ab[i][0]);
    }
    current -= t - ab[m - 1][1];
    if (current <= 0) {
      System.out.println("No");
      return;
    }
    System.out.println("Yes");
  }
}
