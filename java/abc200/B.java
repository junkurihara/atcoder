import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long k = sc.nextLong();

    for (int i = 0; i < k; i++) {
      if (n % 200 == 0) {
        n /= 200;
      } else {
        n = n * 1000 + 200;
      }
    }
    System.out.println(n);
  }
}
