import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    long[][] subarray = new long[N][M];
    for (int i = 0; i < N; i++) {
      long[] row = new long[M];
      Arrays.setAll(row, j -> sc.nextInt());
      Arrays.sort(row);
      subarray[i] = row;
    }

    long base_j = (subarray[0][0] - 1) % 7;
    long base_i = (subarray[0][0] - 1 - base_j) / 7;

    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        long expect_j = (subarray[i][j] - 1) % 7;
        long expect_i = (subarray[i][j] - 1 - expect_j) / 7;
        if (expect_j != base_j + j || expect_i != base_i + i) {
          cnt += 1;
        }
      }
    }
    if (cnt > 0) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }

  }

}
