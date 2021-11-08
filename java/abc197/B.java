import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt();
    int w = sc.nextInt();
    int x = sc.nextInt() - 1;
    int y = sc.nextInt() - 1;

    String[] row = new String[w];
    String[] col = new String[h];
    for (int i = 0; i < h; i++) {
      var r = sc.next().split("");
      if (i == x) {
        row = r;
      }
      col[i] = r[y];
    }

    // System.out.println(Arrays.deepToString(row));
    // System.out.println(Arrays.deepToString(col));

    int cnt = row[y].equals(".") ? 1 : 0;

    for (int i = 1; i < w; i++) {
      if (i + y < w && row[i + y].equals(".")) {
        cnt++;
      } else {
        break;
      }
    }
    for (int i = 1; i < w; i++) {
      if (y >= i && row[y - i].equals(".")) {
        cnt++;
      } else {
        break;
      }
    }

    for (int i = 1; i < h; i++) {
      if (i + x < h && col[i + x].equals(".")) {
        cnt++;
      } else {
        break;
      }
    }
    for (int i = 1; i < h; i++) {
      if (x >= i && col[x - i].equals(".")) {
        cnt++;
      } else {
        break;
      }
    }
    System.out.println(cnt);
  }
}
