import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] ls = new long[n];
    HashMap<Long, Long> hm = new HashMap<>();
    for (int i = 0; i < n; i++) {
      long x = sc.nextLong();
      var num = hm.getOrDefault(x, 0L);
      hm.put(x, num + 1);
    }
    long[] keys = hm.keySet().stream().mapToLong(x -> x).toArray();
    Arrays.sort(keys);
    int len = keys.length;
    int sum = 0;
    for (int i = 0; i < len - 2; i++) {
      for (int j = i + 1; j < len - 1; j++) {
        for (int k = j + 1; k < len; k++) {
          if (keys[i] + keys[j] > keys[k]) {
            sum += hm.get(keys[i]) * hm.get(keys[j]) * hm.get(keys[k]);
          }
        }
      }
    }
    System.out.println(sum);
  }
}
