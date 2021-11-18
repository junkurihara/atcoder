import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long p = (long) Math.pow(2.0, (double) n - 1.0);

    long first_max = 0;
    long first_max_idx = 0;
    for (long i = 0; i < p; i++) {
      long x = sc.nextLong();
      if (first_max < x) {
        first_max = x;
        first_max_idx = i;
      }
    }

    long second_max = 0;
    long second_max_idx = 0;
    for (long i = 0; i < p; i++) {
      long x = sc.nextLong();
      if (second_max < x) {
        second_max = x;
        second_max_idx = i;
      }
    }

    if (first_max > second_max) {
      System.out.println(p + second_max_idx + 1);
    } else {
      System.out.println(first_max_idx + 1);
    }
  }
}
