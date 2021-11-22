import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int sx = sc.nextInt();
    int sy = sc.nextInt();
    int gx = sc.nextInt();
    int gy = sc.nextInt();

    var dist_x = gx - sx;
    var dist_y = gy + sy;
    var a = (double) dist_x / (double) dist_y;
    System.out.println(sx + a * sy);

  }
}
