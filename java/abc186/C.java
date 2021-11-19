import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      if (Integer.toString(i).contains("7") || Integer.toOctalString(i).contains("7")) {
        cnt += 1;
      }
    }
    System.out.println(n - cnt);
  }

}
