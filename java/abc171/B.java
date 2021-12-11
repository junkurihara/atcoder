import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] ps = new int[n];
    Arrays.setAll(ps, i -> sc.nextInt());
    Arrays.sort(ps);
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += ps[i];
    }
    System.out.println(sum);
  }
}
