import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int s = sc.nextInt();
    int d = sc.nextInt();
    int[][] xy = new int[n][2];
    Arrays.setAll(xy, i -> {
      int[] l = { sc.nextInt(), sc.nextInt() };
      return l;
    });

    if (Arrays.stream(xy).anyMatch(l -> l[0] < s && l[1] > d)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
