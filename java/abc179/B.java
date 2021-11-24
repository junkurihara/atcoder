import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] d = new int[n][2];
    Arrays.setAll(d, i -> {
      int[] local = new int[2];
      Arrays.setAll(local, j -> sc.nextInt());
      return local;
    });

    ArrayList<int[]> deq = new ArrayList<>();
    for (int[] x : d) {
      deq.add(x);
      if (deq.size() > 3) {
        deq.remove(0);
        // check here
        if (deq.get(0)[0] == deq.get(0)[1] && deq.get(1)[0] == deq.get(1)[1] && deq.get(2)[0] == deq.get(2)[1]) {
          System.out.println("Yes");
          return;
        }
      }
    }
    System.out.println("No");

  }
}
