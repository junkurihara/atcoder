import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int price = -1;
    for (int i = 0; i < n; i++) {
      int[] triplet = new int[3];
      Arrays.setAll(triplet, j -> sc.nextInt());
      if (triplet[2] - triplet[0] > 0) {
        if (price == -1 || price > triplet[1]) {
          price = triplet[1];
        }
      }
    }

    System.out.println(price);

  }
}
