import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    int hundreds = 100 * k * n * (n + 1) / 2;
    int ones = n * k * (k + 1) / 2;

    int num = hundreds + ones;

    System.out.println(num);

  }
}
