import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    if (C % 2 == 0 || (A >= 0 && B >= 0)) {
      if (Math.abs(A) > Math.abs(B)) {
        System.out.println(">");
      } else if (Math.abs(A) == Math.abs(B)) {
        System.out.println("=");
      } else {
        System.out.println("<");
      }
    } else if (A >= 0 && B < 0) {
      System.out.println(">");
    } else if (A < 0 && B >= 0) {
      System.out.println("<");
    } else {
      if (A > B) {
        System.out.println(">");
      } else if (A == B) {
        System.out.println("=");
      } else {
        System.out.println("<");
      }
    }
  }

}
