import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int l = sc.nextInt();

    long[][] memo = new long[l][12];

    for (int i = 0; i < l; i++) {
      for (int j = 0; j < 12; j++) {
        if (j == 0) {
          memo[i][j] = 1;
          continue;
        }
        if (i == 0) {
          memo[i][j] = 0;
          continue;
        }
        memo[i][j] = memo[i - 1][j] + memo[i - 1][j - 1];
      }
    }

    System.out.println(memo[l - 1][11]);
  }

}
