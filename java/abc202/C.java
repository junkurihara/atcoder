import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n];
    Arrays.setAll(a, i -> sc.nextInt());
    Arrays.setAll(b, i -> sc.nextInt());
    Arrays.setAll(c, i -> sc.nextInt());

    HashMap<Integer, Integer> a_hm = new HashMap<>();
    HashMap<Integer, Integer> bc_hm = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int a_cnt = a_hm.getOrDefault(a[i], 0) + 1;
      a_hm.put(a[i], a_cnt);
      int cj = c[i];
      int bc_cnt = bc_hm.getOrDefault(b[cj - 1], 0) + 1;
      bc_hm.put(b[cj - 1], bc_cnt);
    }

    var a_keyset = a_hm.keySet();
    long sum = 0;
    for (Integer ai : a_keyset) {
      var aj_cnt = (long) a_hm.get(ai);
      var bcj_cnt = (long) bc_hm.getOrDefault(ai, 0);
      sum += aj_cnt * bcj_cnt;
    }
    System.out.println(sum);
  }
}
