import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[][] ab = new long[n][2];
    Arrays.setAll(ab, i -> {
      long[] x = new long[2];
      Arrays.setAll(x, j -> sc.nextLong());
      return x;
    });

    long cnt = 0;
    for (long[] x : ab) {
      long num = x[1] - x[0] + 1;
      cnt += num * x[0];
      cnt += num * (num - 1) / 2;
    }
    System.out.println(cnt);

  }
}
