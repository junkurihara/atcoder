import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    Arrays.setAll(a, i -> sc.nextInt());

    int max_total = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        var slice = Arrays.copyOfRange(a, i, j + 1);
        int min = Arrays.stream(slice).min().getAsInt();
        int total = (j + 1 - i) * min;
        if (total > max_total) {
          max_total = total;
        }
      }
    }
    System.out.println(max_total);

  }

}
