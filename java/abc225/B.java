import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] ab = new int[N - 1][2];
    for (int[] row : ab) {
      Arrays.setAll(row, i -> sc.nextInt());
    }

    HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();

    for (int[] row : ab) {
      hm.putIfAbsent(row[0], new HashSet<Integer>());
      hm.putIfAbsent(row[1], new HashSet<Integer>());
      hm.get(row[0]).add(row[1]);
      hm.get(row[1]).add(row[0]);
    }

    // System.out.println(Arrays.deepToString(ab));
    for (int i = 1; i < N + 1; i++) {
      if (hm.get(i).size() != 1 && hm.get(i).size() != N - 1) {
        System.out.println("No");
        System.exit(0);
      }
    }
    System.out.println("Yes");
  }

}
