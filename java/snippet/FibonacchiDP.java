
// Calculate n-th Fibonacchi number with DP
import java.util.*;

public class FibonacchiDP {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    FBTable fbt = new FBTable(n);
    System.out.println(fbt.recursive_get(n));
    fbt.clear();
    System.out.println(fbt.loop_get(n));
  }

  static private class FBTable {
    private long[] tbl;

    FBTable(int n) {
      this.tbl = new long[n + 1];
    }

    private long loop_get(int i) {
      long[] a = { 0, 1 };

      for (int j = 2; j < i + 1; j++) {
        long tmp = a[0] + a[1];
        a[0] = a[1];
        a[1] = tmp;
      }
      return a[1];
    }

    private void clear() {
      var len = tbl.length;
      this.tbl = new long[len];
    }

    private long recursive_get(int i) {
      if (i == 0)
        return 0L;
      if (i == 1)
        return 1L;
      if (this.tbl[i] == 0) {
        this.tbl[i] = this.recursive_get(i - 1) + this.recursive_get(i - 2);
        return this.tbl[i];
      }
      return this.tbl[i];
    }
  }
}
