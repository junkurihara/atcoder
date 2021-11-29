import java.util.*;

public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s = sc.next().split("");
    int k = sc.nextInt();

    long[] accBlank = new long[s.length + 1];
    long cntdot = 0;
    accBlank[0] = 0;
    for (int i = 1; i < s.length + 1; i++) {
      if (s[i - 1].equals(".")) {
        cntdot += 1;
      }
      accBlank[i] = cntdot;
    }

    long maxSumXs = 0;
    int ptr_end = 0;
    for (int begin = 0; begin < s.length; begin++) {

      while (ptr_end < s.length && accBlank[ptr_end + 1] - accBlank[begin] <= k) {
        ptr_end += 1;
      }

      maxSumXs = Math.max(ptr_end - begin, maxSumXs);
    }

    System.out.println(maxSumXs);
  }
}
