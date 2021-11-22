import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt() - 1;
    int[] a = new int[n];
    Arrays.setAll(a, i -> sc.nextInt() - 1);

    HashSet<Integer> hs = new HashSet<>();
    int current = x;
    while (!hs.contains(current)) {
      hs.add(current);
      current = a[current];
    }
    System.out.println(hs.size());
  }
}
