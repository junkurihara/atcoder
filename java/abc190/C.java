import java.util.*;
import java.util.stream.Collectors;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] ab = new int[m][2];
    Arrays.setAll(ab, i -> {
      int[] l = { sc.nextInt(), sc.nextInt() };
      return l;
    });
    int k = sc.nextInt();
    int[][] cd = new int[k][2];
    Arrays.setAll(cd, i -> {
      int[] l = { sc.nextInt(), sc.nextInt() };
      return l;
    });

    Rule rule = new Rule(ab);
    Deque<int[]> cd_list = new LinkedList<>(Arrays.stream(cd).collect(Collectors.toList()));
    System.out.println(rule.calc(cd_list));
  }

  private static class Rule {
    private int[][] ab;

    Rule(int[][] ab) {
      this.ab = ab;
    }

    private int calc(Deque<int[]> que) {
      HashSet<Integer> hs = new HashSet<>();
      return this.calc(que, hs);
    }

    private int calc(Deque<int[]> que, HashSet<Integer> hs) {
      if (que.peekLast() == null) {
        // System.out.println(hs.toString());
        var size = Arrays.stream(this.ab).filter(c -> hs.contains(c[0]) && hs.contains(c[1]))
            .collect(Collectors.toList()).size();
        return size;
      } else {
        int[] polled = que.pollLast();
        var que_1 = new LinkedList<int[]>(que);
        var hs_1 = new HashSet<Integer>(hs);
        hs_1.add(polled[0]);
        var val_1 = this.calc(que_1, hs_1);

        var que_2 = new LinkedList<int[]>(que);
        var hs_2 = new HashSet<Integer>(hs);
        hs_2.add(polled[1]);
        var val_2 = this.calc(que_2, hs_2);
        return Math.max(val_1, val_2);
      }
    }
  }

}
