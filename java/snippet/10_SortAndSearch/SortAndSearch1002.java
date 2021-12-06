import java.util.*;

// 文字列の配列を、アナグラムになっている文字列がお互い隣り合うように並び替えるメソッドを書いてください。

public class SortAndSearch1002 {
  public static void main(String[] args) {
    String[] strs = { "abc", "bac", "aaa", "xyz", "cba", "zyx" };
    sort(strs);
  }

  private static void sort(String[] strArray) {
    HashMap<String, ArrayList<String>> hm = new HashMap<>();
    for (String s : strArray) {
      String[] sorted = s.split("");
      Arrays.sort(sorted);
      String joined = String.join("", sorted);
      var al = hm.getOrDefault(joined, new ArrayList<>());
      al.add(s);
      hm.put(joined, al);
    }

    hm.values().stream().forEach(list -> {
      for (String elem : list) {
        System.out.println(elem);
      }
    });
  }

}
