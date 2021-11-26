import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int cnt = 0;
    for (int a = 1; a < n; a++) {
      cnt += (int) Math.floor((double) (n - 1.0) / (double) a);
    }
    System.out.println(cnt);
  }
}
