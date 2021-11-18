import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] xy = new int[n][2];
    Arrays.setAll(xy, i -> {
      int[] l = new int[2];
      Arrays.setAll(l, j -> sc.nextInt());
      return l;
    });

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        var divisor = Math.abs(xy[i][0] - xy[j][0]);
        var dividee = Math.abs(xy[i][1] - xy[j][1]);
        if (dividee <= divisor) {
          cnt += 1;
        }
      }
    }
    System.out.println(cnt);

  }

}
