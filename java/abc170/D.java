import java.util.*;

public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] as = new int[n];
    Arrays.setAll(as, i -> sc.nextInt());

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      boolean flag = true;
      for (int j = 0; j < n; j++) {
        if (i != j && (as[i] % as[j]) == 0) {
          flag = false;
          break;
        }
      }
      if (flag) {
        cnt++;
      }
    }
    System.out.println(cnt);

  }
}
