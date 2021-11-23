import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    Arrays.setAll(a, i -> sc.nextInt());
    var max = Arrays.stream(a).max().getAsInt();

    int max_size = 0;
    int max_val = 0;
    for (int i = 2; i <= max; i++) {

      int filtered_size = 0;
      for (int x : a) {
        filtered_size += (x % i == 0) ? 1 : 0;
      }
      if (max_size <= filtered_size) {
        max_size = filtered_size;
        max_val = i;
      }
    }

    System.out.println(max_val);

  }
}
