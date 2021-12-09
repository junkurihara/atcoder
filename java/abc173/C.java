import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt();
    int w = sc.nextInt();
    int k = sc.nextInt();
    String[][] s = new String[h][w];
    for (int i = 0; i < h; i++) {
      s[i] = sc.next().split("");
    }

    int cnt = 0;
    int maxR = 1 << h;
    int maxC = 1 << w;
    for (int r = 0; r < maxR; r++) {
      for (int c = 0; c < maxC; c++) {
        if (check(r, c, s, k))
          cnt += 1;
      }
    }
    System.out.println(cnt);

  }

  private static boolean check(int r, int c, String[][] s, int k) {
    int cnt = 0;
    for (int i = 0; i < s.length; i++) {
      int maski = r & (1 << i);
      if (maski > 0) {
        for (int j = 0; j < s[i].length; j++) {
          int maskj = c & (1 << j);
          if (maskj > 0 && s[i][j].equals("#")) {
            cnt += 1;
          }
        }
      }
    }
    // System.out.println(cnt);
    return cnt == k;
  }
}
