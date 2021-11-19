import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt();
    int w = sc.nextInt();
    int[][] a = new int[h][w];
    Arrays.setAll(a, i -> {
      int[] l = new int[w];
      Arrays.setAll(l, j -> sc.nextInt());
      return l;
    });

    int cnt = 0;
    int min = 100;
    for (int i = 0; i < h; i++) {
      cnt += Arrays.stream(a[i]).reduce(0, (acc, x) -> acc + x);
      var local_min = Arrays.stream(a[i]).min().getAsInt();
      if (local_min < min) {
        min = local_min;
      }
    }
    cnt = cnt - (min * h * w);
    System.out.println(cnt);

  }
}
