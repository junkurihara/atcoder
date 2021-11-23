import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] xy = new int[n][2];
    Arrays.setAll(xy, i -> {
      int[] local = new int[2];
      Arrays.setAll(local, j -> sc.nextInt());
      return local;
    });

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (check(xy[i], xy[j], xy[k])) {
            System.out.println("Yes");
            return;
          }
        }
      }
    }
    System.out.println("No");
  }

  private static boolean check(int[] a, int[] b, int[] c) {
    // y = u x + w
    // a -> (0, 0)
    int[] mapped_b = { b[0] - a[0], b[1] - a[1] };
    int[] mapped_c = { c[0] - a[0], c[1] - a[1] };
    return (mapped_b[0] * mapped_c[1] == mapped_b[1] * mapped_c[0]);
  }
}
