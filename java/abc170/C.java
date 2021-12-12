import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int n = sc.nextInt();
    int[] given = new int[n];
    Arrays.setAll(given, i -> sc.nextInt());
    Arrays.sort(given);
    HashSet<Integer> notContained = new HashSet<>();
    if (n > 0) {
      for (int i = 1; i <= given[given.length - 1] + 1; i++) {
        notContained.add(i);
      }
      for (int i = 0; i < n; i++) {
        notContained.remove(given[i]);
      }
      int diff = x;
      int current = 0;
      int[] arrayed = notContained.stream().mapToInt(i -> (int) i).toArray();
      for (int i : arrayed) {
        if (diff > Math.abs(x - i)) {
          diff = Math.abs(x - i);
          current = i;
        }
      }
      System.out.println(current);
      return;
    }
    System.out.println(x);

  }
}
