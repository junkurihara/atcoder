import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt() * 100;
    int[] vp = new int[n];
    Arrays.setAll(vp, i -> {
      int v = sc.nextInt();
      int p = sc.nextInt();
      return v * p;
    });

    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += vp[i - 1];
      if (sum > x) {
        System.out.println(i);
        return;
      }
    }

    System.out.println("-1");

  }
}
