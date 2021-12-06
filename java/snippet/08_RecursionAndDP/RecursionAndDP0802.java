import java.util.*;

// r行とc列のグリッド上の左上にロボットが座っています。
// ロボットは右と下の2つの方向にしか進むことができません。
// ロボットが通ることのできない立ち入り禁止のセルがあるとした場合、左上の地点から右下の地点まで移動する経路を見つけるアルゴリズムを設計してください。

public class RecursionAndDP0802 {
  public static void main(String[] args) {
    var path = new Path();
    path.getPath();
  }
}

class Path {
  public void getPath() {
    int r = 100;
    int c = 100;
    boolean[][] canBeEnter = new boolean[r][c];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        canBeEnter[i][j] = true;
      }
    }
    // canBeEnter[r - 2][c - 1] = false;
    // canBeEnter[r - 1][c - 2] = false;
    Point[][] points = new Point[r][c];
    Arrays.setAll(points, i -> {
      Point[] row = new Point[c];
      Arrays.setAll(row, j -> {
        return new Point(i, j);
      });
      return row;
    });

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < r; j++) {
        if (canBeEnter[i][j]) {
          if (i > 0) {
            if (points[i - 1][j].previousPoints.size() > 0 || (i == 1 && j == 0)) {
              points[i][j].previousPoints.add(points[i - 1][j]);
            }
          }
          if (j > 0) {
            if (points[i][j - 1].previousPoints.size() > 0 || (i == 0 && j == 1)) {
              points[i][j].previousPoints.add(points[i][j - 1]);
            }
          }
        }
      }
    }

    if (points[r - 1][c - 1].previousPoints.size() > 0) {
      Deque<Point> step = new LinkedList<>();
      var current = points[r - 1][c - 1];
      while (current.colIdx > 0 || current.rowIdx > 0) {
        step.addFirst(current);
        current = current.previousPoints.stream().map(x -> x).toList().get(0);
      }
      System.out.println("Path exists!");
      for (Point p : step) {
        System.out.println(p.colIdx + ", " + p.rowIdx);
      }
    } else {
      System.out.println("Path doesn't exist!");
    }

  }

  class Point {
    public int rowIdx;
    public int colIdx;
    public HashSet<Point> previousPoints;

    public Point(int rowIdx, int colIdx) {
      this.rowIdx = rowIdx;
      this.colIdx = colIdx;
      this.previousPoints = new HashSet<>();
    }
  }
}
