import java.util.*;

public class B {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s = sc.next().split("");
    String[] t = sc.next().split("");

    int s_len = s.length;
    int t_len = t.length;
    int max_overwrap = 0;
    for (int i = 0; i < s_len - t_len + 1; i++) {
      int overwrap = 0;
      for (int j = 0; j < t_len; j++) {
        if (s[i + j].equals(t[j])) {
          overwrap += 1;
        }
      }
      if (max_overwrap < overwrap) {
        max_overwrap = overwrap;
      }
    }
    // System.out.println(max_overwrap);
    System.out.println(t_len - max_overwrap);
  }

}
