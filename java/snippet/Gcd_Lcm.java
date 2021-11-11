import java.util.*;

public class Gcd_Lcm {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    System.out.println("gcd: " + gcd(a,b));
    System.out.println("lcm: " + lcm(a,b));
  }

  private static int gcd(int a, int b) {
    return  (a % b == 0) ? Math.abs(b) : gcd(b, a % b);
  }

  private static int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }

}
