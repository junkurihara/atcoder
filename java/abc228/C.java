import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] p = new int[n];
    Arrays.setAll(p, i -> sc.nextInt() + sc.nextInt() + sc.nextInt());
    int[] sorted = p.clone();
    Arrays.sort(sorted);

    for (int i = 0; i < n; i++) {
      if (sorted[n - k] <= p[i] + 300) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }

  }
}
