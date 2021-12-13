import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long a = sc.nextLong();
    String[] b = sc.next().split("");
    long[] bLong = Arrays.stream(b)
        .filter(s -> !s.equals("."))
        .map(x -> Long.parseLong(x))
        .mapToLong(x -> (long) x)
        .toArray();

    // System.out.println(Arrays.toString(bLong));

    long prod = a * bLong[0];
    long prodPoint = (a * bLong[1] + (a * bLong[2] / 10)) / 10;
    System.out.println(prod + prodPoint);
  }
}
