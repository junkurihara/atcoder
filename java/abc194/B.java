import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] ab = new int[n][3];
    Arrays.setAll(ab, i -> {
      int[] x = new int[3];
      x[0] = sc.nextInt();
      x[1] = sc.nextInt();
      x[2] = x[0] + x[1];
      return x;
    });

    int min_sum = 100000;
    for (int[] x : ab) {
      if (x[2] < min_sum) {
        min_sum = x[2];
      }
    }
    int min_ab = 100000;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j) {
          if (min_ab > Math.max(ab[i][0], ab[j][1])) {
            min_ab = Math.max(ab[i][0], ab[j][1]);
          }
        }
      }
    }
    System.out.println(Math.min(min_ab, min_sum));

  }
}
