import java.util.*;
import java.util.stream.IntStream;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] s = sc.next().chars().toArray();
    int lower_min = "a".chars().toArray()[0];
    int lower_max = "z".chars().toArray()[0];
    int upper_min = "A".chars().toArray()[0];
    int upper_max = "Z".chars().toArray()[0];

    int idx = 0;
    for (int c : s) {
      if (idx % 2 == 0) { // odd
        if (!(c >= lower_min && c <= lower_max)) {
          System.out.println("No");
          return;
        }
      } else { // even
        if (!(c >= upper_min && c <= upper_max)) {
          System.out.println("No");
          return;
        }
      }
      idx++;
    }
    System.out.println("Yes");
  }
}
