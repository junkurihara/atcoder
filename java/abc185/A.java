import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] a = new int[4];
    Arrays.setAll(a, i -> sc.nextInt());
    System.out.println(Arrays.stream(a).min().getAsInt());
  }
}
