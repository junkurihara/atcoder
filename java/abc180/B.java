import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long[] x = new long[n];
    Arrays.setAll(x, i -> sc.nextLong());
    System.out.println(dist1(x));
    System.out.println(dist2(x));
    System.out.println(dist3(x));
  }

  private static long dist1(long[] x) {
    return Arrays.stream(x).reduce(0, (acc, e) -> acc + Math.abs(e));
  }

  private static double dist2(long[] x) {
    long sum = Arrays.stream(x).reduce(0, (acc, e) -> acc + e * e);
    return Math.sqrt((double) sum);
  }

  private static long dist3(long[] x) {
    return Arrays.stream(x).map(e -> Math.abs(e)).max().getAsLong();
  }
}
