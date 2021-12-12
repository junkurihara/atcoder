import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = 0;
    for (int i = 1; i <= 5; i++) {
      if (sc.nextInt() == 0) {
        x = i;
      }
    }
    System.out.println(x);

  }
}
