import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long x = sc.nextLong();
    long k = sc.nextLong();
    long d = sc.nextLong();

    long abs_x = Math.abs(x);
    long moved_distance = abs_x - (abs_x % d);
    long moved_count = moved_distance / d;

    if (moved_count >= k) {
      System.out.println(abs_x - k * d);
      return;
    }

    if ((k - moved_count) % 2 == 0) {
      System.out.println(abs_x - moved_distance);
      return;
    }

    System.out.println(Math.abs(abs_x - moved_distance - d));

  }
}
