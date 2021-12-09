import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int num = (n % 1000 > 0) ? n - (n % 1000) + 1000 : n - (n % 1000);
    System.out.println(num - n);
  }
}
