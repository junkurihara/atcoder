import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long w = sc.nextLong();
    ArrayList<AB> ab = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      long a = sc.nextLong();
      long b = sc.nextLong();
      ab.add(new AB(a, b));
    }

    ab.sort((x, y) -> {
      Long xl = Long.valueOf(x.a);
      Long yl = Long.valueOf(y.a);
      return yl.compareTo(xl);
    });

    long sum = 0;
    long remain = w;
    for (AB e : ab) {
      if (remain > 0) {
        long g = Math.min(e.b, remain);
        remain -= g;
        sum += g * e.a;
      } else {
        break;
      }

    }
    System.out.println(sum);
  }

  private static class AB {
    private long a;
    private long b;

    AB(long a, long b) {
      this.a = a;
      this.b = b;
    }
  }

}
