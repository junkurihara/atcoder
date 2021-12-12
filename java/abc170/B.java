import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();
    // x = a + b
    // y = 2a + 4b;
    // y - 2x = 2b
    // y = 2a + 2(y-2x) -> 4x - y = 2a

    if (y - 2 * x >= 0 && (y - 2 * x) % 2 == 0
        && 4 * x - y >= 0 && (4 * x - y) % 2 == 0) {
      System.out.println("Yes");
      return;
    }
    System.out.println("No");
  }
}
