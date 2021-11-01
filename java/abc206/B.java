import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    // i**2+i-2n >= 0
    double ans = (-1.0D + Math.sqrt(1.0D + 8.0D * (double) N)) / 2.0D;
    System.out.println((int) Math.ceil(ans));
  }

}
