import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n >= 42) {
      n += 1;
    }
    System.out.println("AGC0" + String.format("%02d", n));
  }

}
