import java.util.*;

public class C {
  static final String[] target = "chokudai".split("");
  static final long div = (long) Math.pow(10.0, 9.0) + 7;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    String[] source = s.split("");

    long[][] cnt = new long[source.length + 1][target.length + 1];
    for (int i = 0; i < source.length + 1; i++) {
      for (int j = 0; j < target.length + 1; j++) {
        if (j == 0) {
          cnt[i][j] = 1;
          continue;
        }
        if (i == 0) {
          cnt[i][j] = 0;
          continue;
        }
        var ptr_s = i - 1;
        var ptr_t = j - 1;
        if (source[ptr_s].equals(target[ptr_t])) {
          cnt[i][j] = (cnt[i - 1][j - 1] + cnt[i - 1][j]) % div;
          continue;
        }
        cnt[i][j] = cnt[i - 1][j];
      }
    }

    System.out.println(cnt[source.length][target.length]);
  }
}
