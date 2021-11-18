import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    Arrays.setAll(a, i -> sc.nextInt());
    // int[] b = new int[n];
    // Arrays.setAll(b, i -> sc.nextInt());
    int ip = Arrays.stream(a).boxed().reduce(0, (acc, e) -> {
      int b = sc.nextInt();
      return acc + b * e;
    });

    if (ip == 0) {
      System.out.println("Yes");
      return;
    }
    System.out.println("No");

  }
}
