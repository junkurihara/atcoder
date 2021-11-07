import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String s = sc.next();

    int q = sc.nextInt();
    int[][] queries = new int[q][3];
    for (int i = 0; i < q; i++) {
      Arrays.setAll(queries[i], j -> sc.nextInt());
    }

    String[] str = s.split("");
    String[][] seq = new String[2][n];
    for (int i = 0; i < n; i++) {
      seq[0][i] = str[i];
      seq[1][i] = str[n + i];
    }

    int flip_cnt = 0;
    for (int[] query : queries) {
      if (query[0] == 1) {
        int place_a = (flip_cnt + (query[1] - 1 - ((query[1] - 1) % n)) / n) % 2;
        int place_b = (flip_cnt + (query[2] - 1 - ((query[2] - 1) % n)) / n) % 2;
        var tmp = seq[place_a][(query[1] - 1) % n];
        seq[place_a][(query[1] - 1) % n] = seq[place_b][(query[2] - 1) % n];
        seq[place_b][(query[2] - 1) % n] = tmp;
      } else {
        flip_cnt += 1;
      }
    }

    System.out.println(String.join("", seq[flip_cnt % 2]) + String.join("", seq[(flip_cnt + 1) % 2]));

  }
}
