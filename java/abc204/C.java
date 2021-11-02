import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] ab = new int[m][2];
    for (int i = 0; i < m; i++) {
      Arrays.setAll(ab[i], j -> sc.nextInt());
    }

    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
    for (int i = 0; i < m; i++) {
      var entry = hm.get(ab[i][0]);
      if (entry == null) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(ab[i][1]);
        hm.put(ab[i][0], al);
      } else {
        entry.add(ab[i][1]);
        hm.put(ab[i][0], entry);
      }
    }

    int cnt = 0;
    for (int i = 1; i < n + 1; i++) {
      HashSet<Integer> stamp = new HashSet<>();
      stamp.add(i);
      findNext(i, stamp, hm);
      cnt += stamp.size();
    }

    System.out.println(cnt);
  }

  public static void findNext(int current, HashSet<Integer> stamp, HashMap<Integer, ArrayList<Integer>> hm) {
    var nexts = hm.get(current);
    if (nexts != null) {
      for (Integer p : nexts) {
        if (!stamp.contains(p)) {
          stamp.add(p);
          findNext(p, stamp, hm);
        }
      }
    }
  }
}
