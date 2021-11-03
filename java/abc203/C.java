import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long k = sc.nextLong();

    HashMap<Long, Long> hm = new HashMap<>();
    for (long i = 0; i < n; i++) {
      long idx = sc.nextLong();
      long money = sc.nextLong();
      long update = hm.getOrDefault(idx, 0L) + money;
      hm.put(idx, update);
    }

    var keySet = hm.keySet();
    var size = keySet.size();
    long[][] compressed = new long[size][2];
    int idx = 0;
    for (long key : keySet) {
      compressed[idx][0] = key;
      compressed[idx][1] = hm.get(key);
      idx += 1;
    }
    Arrays.sort(compressed, (a, b) -> Long.compare(a[0], b[0]));

    long sum = k;
    for (long[] pair : compressed) {
      if (pair[0] > sum) {
        break;
      }
      sum += pair[1];
    }
    System.out.println(sum);
  }
}
