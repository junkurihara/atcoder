import java.util.*;

// class Car {
//   public int x = 0;
// }

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double A = sc.nextDouble();
    double B = sc.nextDouble();
    double C = sc.nextDouble();
    double D = sc.nextDouble();

    // A + Bx = CDx
    // A/(CD-B) = x

    if (C * D - B <= 0) {
      System.out.println("-1");
    } else {
      double cross = A / (C * D - B);
      System.out.println((long) Math.ceil(cross));
    }

  }
}
