import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    HashMap<Integer, String> mt_hm = new HashMap<>();
    int max_height = 0;
    int next_height = 0;
    for (int i = 0; i < n; i++) {
      String name = sc.next();
      int height = sc.nextInt();
      mt_hm.put(height, name);
      if (Math.max(max_height, height) == height) {
        next_height = max_height;
        max_height = height;
      } else if (Math.max(next_height, height) == height) {
        next_height = height;
      }
    }
    System.out.println(mt_hm.get(next_height));

  }
}
