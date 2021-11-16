import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    int val = n;
    for (int i = 1; i < k + 1; i++) {
      val = func(val);
    }
    System.out.println(val);
  }

  private static int func(int x) {
    String[] s = Integer.toString(x).split("");
    int[] x_arr = Arrays.stream(s).mapToInt(y -> Integer.parseInt(y)).toArray();
    Arrays.sort(x_arr);

    int max = 0;
    int min = 0;
    int idx = 0;
    for (int e : x_arr) {
      max += e * (int) Math.pow(10.0, (double) idx);
      min += e * (int) Math.pow(10.0, (double) x_arr.length - idx - 1);
      idx += 1;
    }
    return max - min;
  }
}
