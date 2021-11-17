import java.util.*;

// NOTE: THIS DOESN'T WORK
public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double x = sc.nextDouble();
    double y = sc.nextDouble();
    double r = sc.nextDouble();
    Circle c = new Circle(x, y, r);

    // Arrays.stream(a).boxed().filter(j -> x - j != 0).forEach(j ->
    // System.out.print(j + " "));
    System.out.println(c.count_included());
  }

  private static class Circle {
    private double x;
    private double y;
    private double r_square;
    private int max_x_grid;
    private int min_x_grid;
    private int max_y_grid;
    private int min_y_grid;

    Circle(double x, double y, double r) {
      this.x = x;
      this.y = y;
      this.r_square = Math.pow(r, 2.0);
      this.max_x_grid = (int) Math.floor(x + r);
      this.min_x_grid = (int) Math.ceil(x - r);
      this.max_y_grid = (int) Math.floor(y + r);
      this.min_y_grid = (int) Math.ceil(y - r);
    }

    public int count_included() {
      int cnt = 0;
      for (int i = min_x_grid; i <= max_x_grid; i++) {
        for (int j = min_y_grid; j <= max_y_grid; j++) {
          double dist = Math.pow(((double) i - this.x), 2.0) + Math.pow(((double) j - this.y), 2.0);
          if (dist <= this.r_square) {
            cnt += 1;
          }
        }
      }
      return cnt;
    }
  }
}
