import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] a = new long[n];
    Arrays.setAll(a, i -> sc.nextLong());

    HashMap<Long, Long> hm = new HashMap<>();

    for (Long p : a) {
      long cnt = hm.getOrDefault(p % 200, 0L);
      hm.put(p % 200, cnt + 1);
    }

    long cnt = 0;
    for (Long p : hm.keySet()) {
      long local_cnt = hm.get(p);
      cnt += (local_cnt - 1) * local_cnt / 2;
    }

    System.out.println(cnt);
  }
}
