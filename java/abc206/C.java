import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    long[] As = new long[(int) N];
    Arrays.setAll(As, i -> sc.nextInt());

    Map<Long, Long> hm = new HashMap<>();
    long cnt = 0;

    for (int i = 0; i < N; i++) {
      long target = As[N - i - 1];
      long target_cnt = hm.getOrDefault(target, 0L);
      cnt += (i - target_cnt);
      hm.put(target, target_cnt + 1);
    }

    System.out.println(cnt);
  }
}
