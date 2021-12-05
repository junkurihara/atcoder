import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long a = sc.nextLong();
    long b = sc.nextLong();
    long[] pq = new long[2];
    long[] rs = new long[2];
    Arrays.setAll(pq, i -> sc.nextLong());
    Arrays.setAll(rs, i -> sc.nextLong());

    long[] firstRange = new long[2];
    firstRange[0] = Math.max(1 - a, 1 - b);
    firstRange[1] = Math.min(n - a, n - b);
    long[] secondRange = new long[2];
    secondRange[0] = Math.max(1 - a, b - n);
    secondRange[1] = Math.min(n - a, b - 1);

    for (long i = pq[0]; i <= pq[1]; i++) {
      String[] word = new String[(int) (rs[1] - rs[0] + 1)];
      Arrays.setAll(word, j -> ".");
      long exp_i = i - a;
      if (exp_i >= rs[0] - b && exp_i <= rs[1] - b && (exp_i >= firstRange[0] && exp_i <= firstRange[1])) {
        word[(int) (b + exp_i - rs[0])] = "#";
      }
      if (exp_i >= b - rs[1] && exp_i <= b - rs[0] && (exp_i >= secondRange[0] && exp_i <= secondRange[1])) {
        word[(int) (b - exp_i - rs[0])] = "#";
      }

      System.out.println(String.join("", word));
    }

  }

}
