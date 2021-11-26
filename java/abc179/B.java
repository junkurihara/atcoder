import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] d = new int[n][2];
    Arrays.setAll(d, i -> {
      int[] local = new int[2];
      Arrays.setAll(local, j -> sc.nextInt());
      return local;
    });

    for (int ptr = 0; ptr < n; ptr++) {
      if (ptr < n - 2) {
        if (d[ptr][0] == d[ptr][1] && d[ptr + 1][0] == d[ptr + 1][1] && d[ptr + 2][0] == d[ptr + 2][1]) {
          System.out.println("Yes");
          return;
        }
      }
    }
    System.out.println("No");

  }
}
