import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    Arrays.setAll(a, i -> sc.nextInt());

    int max_total = 0;
    for (int i = 0; i < n; i++) {
      ArrayList<Integer> list_a = new ArrayList<>();
      list_a.add(a[i]);
      var min = a[i];
      for (int j = i; j < n; j++) {
        if (a[j] < min) {
          min = a[j];
        }
        int total = (j + 1 - i) * min;
        if (total > max_total) {
          max_total = total;
        }
      }
    }
    System.out.println(max_total);

  }

}
