import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    Arrays.setAll(a, i -> sc.nextInt());
    HashMap<Integer, Integer> counter = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        var val = Math.abs(a[j] - a[i]);
        var cnt = counter.getOrDefault(val, 0);
        counter.put(val, cnt + 1);
      }
    }
    int sum = 0;
    for (int key : counter.keySet()) {
      var val = counter.get(key);
      sum += key * key * val;
    }
    System.out.println(sum);
  }
}
