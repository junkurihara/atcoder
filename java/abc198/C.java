import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double r = sc.nextDouble();
    double x = sc.nextDouble();
    double y = sc.nextDouble();

    var distance = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));
    var step = Math.ceil(distance / r);

    if (distance % r == 0 || step > 1) {
      System.out.println((int) step);
    } else {
      System.out.println((int) step + 1);
    }
  }
}
