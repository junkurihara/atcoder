import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long d_sq = sc.nextLong();
    d_sq *= d_sq;

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      long x = sc.nextLong();
      long y = sc.nextLong();
      if (x * x + y * y <= d_sq) {
        cnt += 1;
      }
    }
    System.out.println(cnt);
  }
}
