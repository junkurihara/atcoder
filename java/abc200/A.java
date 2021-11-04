import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    var inc = n - 1;
    var century = (inc - (inc % 100)) / 100 + 1;
    System.out.println(century);
  }
}
