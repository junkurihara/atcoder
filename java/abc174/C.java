import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();

    int x1 = 7 % k;
    for (int i = 1; i < k + 1; i++) {
      if (x1 == 0) {
        System.out.println(i);
        return;
      }
      int x2 = (10 * x1 + 7) % k;
      x1 = x2;
    }
    System.out.println(-1);
  }
}
