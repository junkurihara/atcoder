import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int w = sc.nextInt();
    System.out.println((n - (n % w)) / w);
  }
}
