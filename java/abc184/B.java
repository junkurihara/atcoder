import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt();
    String[] s = sc.next().split("");

    int cnt = x;
    for (String p : s) {
      if (p.equals("x")) {
        cnt = Math.max(0, cnt - 1);
      } else {
        cnt += 1;
      }
    }
    System.out.println(cnt);

  }
}
