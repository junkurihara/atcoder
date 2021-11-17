import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt();
    int w = sc.nextInt();
    String[][] s = new String[h][w];
    Arrays.setAll(s, i -> sc.next().split(""));

    int cnt = 0;
    for (int r = 0; r < h - 1; r++) {
      for (int c = 0; c < w - 1; c++) {
        int cnt_local = 0;
        cnt_local += (s[r][c].equals("#")) ? 1 : 0;
        cnt_local += (s[r + 1][c].equals("#")) ? 1 : 0;
        cnt_local += (s[r][c + 1].equals("#")) ? 1 : 0;
        cnt_local += (s[r + 1][c + 1].equals("#")) ? 1 : 0;
        if (cnt_local == 1 || cnt_local == 3)
          cnt += 1;
      }
    }

    System.out.println(cnt);
  }
}
