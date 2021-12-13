import java.util.*;

// 10^18 = 2^{10 * 6} = 2^60
public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long max_val = (long) Math.pow(10.0, 18.0);
    int n = sc.nextInt();
    long[] as = new long[n];
    Arrays.setAll(as, i -> sc.nextLong());
    Arrays.sort(as);
    long cnt = 1;
    for (long a : as) {
      if (a == 0) {
        System.out.println(0);
        return;
      }
      if (cnt > max_val / a) {
        System.out.println(-1);
        return;
      }
      cnt *= a;
    }
    System.out.println(cnt);
  }
}
