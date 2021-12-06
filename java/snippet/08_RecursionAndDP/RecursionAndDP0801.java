
// DP problem 8.1
import java.util.*;

public class RecursionAndDP0801 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Stair s = new Stair(n);
    System.out.println(s.calc(n));
    Stair s2 = new Stair(n);
    System.out.println(s.calcLoop(n));
  }

  private static class Stair {
    long[] stairPattern;

    Stair(int n) {
      this.stairPattern = new long[n + 1];
    }

    // bottom up
    private long calcLoop(int length) {
      for (int i = 0; i < length + 1; i++) {
        if (i == 0) {
          this.stairPattern[0] = 1;
          continue;
        }
        if (i == 1) {
          this.stairPattern[1] = 1;
          continue;
        }
        if (i == 2) {
          this.stairPattern[2] = 2;
          continue;
        }
        this.stairPattern[i] = this.stairPattern[i - 1] + this.stairPattern[i - 2] + this.stairPattern[i - 3];
      }
      return this.stairPattern[length];
    }

    // top down recursive
    private long calc(int remain) {
      if (remain == 1)
        return 1; // (1)
      if (remain == 2)
        return 2; // (1, 1) or (2)
      if (remain == 3)
        return 4; // (1, 1, 1) or (1, 2) or (2, 1) or (3)
      if (this.stairPattern[remain] == 0) {
        this.stairPattern[remain] = this.calc(remain - 1) + this.calc(remain - 2) + this.calc(remain - 3);
      }
      return this.stairPattern[remain];
    }
  }

}
