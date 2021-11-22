import java.util.*;

public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long q = sc.nextLong();
    long len = 1048576;
    HashMap<Long, Long> hm = new HashMap<>();

    long[][] tx = new long[(int) q][(int) len];
    Arrays.setAll(tx, i -> {
      long[] local = new long[2];
      local[0] = sc.nextLong();
      local[1] = sc.nextLong();
      return local;
    });

    for (int i = 0; i < q; i++) {
      if (tx[i][0] == 1) {
        long h = tx[i][1];
        while (hm.containsKey(h % len)) {
          h += 1;
        }
        hm.put(h % len, tx[i][1]);
      } else {
        if (hm.get(tx[i][1] % len) != null) {
          System.out.println(hm.get(tx[i][1] % len));
        } else {
          System.out.println(-1);
        }
      }
    }

  }
}
