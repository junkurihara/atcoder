import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long div = 1_000_000_000 + 7;

    long pow9n = 1;
    long pow8n = 1;
    long pow10n = 1;
    for (int i = 1; i < n + 1; i++) {
      pow10n = (pow10n * 10) % div;
      pow9n = (pow9n * 9) % div;
      pow8n = (pow8n * 8) % div;
    }

    System.out.println(
        (div + (pow10n - 2 * pow9n + pow8n) % div) % div);
  }
}
