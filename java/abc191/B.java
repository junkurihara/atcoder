import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long x = sc.nextLong();
    long[] a = new long[n];
    Arrays.setAll(a, i -> sc.nextLong());

    Arrays.stream(a).boxed().filter(j -> x - j != 0).forEach(j -> System.out.print(j + " "));
    System.out.print("\n");
  }
}
