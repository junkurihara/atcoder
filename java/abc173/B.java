import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    HashMap<String, Integer> hm = new HashMap<>();
    String[] keys = { "AC", "WA", "TLE", "RE" };

    for (int i = 0; i < n; i++) {
      String str = sc.next();
      int cnt = hm.getOrDefault(str, 0);
      hm.put(str, cnt + 1);
    }

    Arrays.stream(keys).forEach(k -> {
      int cnt = hm.getOrDefault(k, 0);
      System.out.println(k + " x " + cnt);
    });

  }
}
