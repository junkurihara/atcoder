import java.util.*;

// 文字列の全ての準列を計算するメソッドを書いてください。
// ただし、文字列には同じ文字が含まれているかもしれません。
// 同じ文字列が含まれないように順列のリストを作ってください。
// NOT SOLVED YET;

public class RecursionAndDP0808 {
  public static void main(String[] args) {
    String[] stringArray = "abc".split("");
    HashMap<String, Integer> hm = new HashMap<>();

    Arrays.stream(stringArray).forEach(s -> {
      int v = hm.getOrDefault(s, 0);
      hm.put(s, v + 1);
    });
    System.out.println(hm.toString());
    var al = buildString(hm);
    // System.out.println(al.toString());
    System.out.println(al.size());
    HashSet<ArrayList<String>> mm = new HashSet<>();
    mm.addAll(al);
    System.out.println(mm.size());
    System.out.println(mm.toString());
  }

  static private ArrayList<ArrayList<String>> buildString(HashMap<String, Integer> hm) {
    ArrayList<ArrayList<String>> ordered = new ArrayList<>();

    var keys = hm.keySet();
    if (keys.size() == 1) {
      String key = keys.stream().toList().get(0);
      if (hm.get(key) == 1) {
        ArrayList<String> newList = new ArrayList<>();
        newList.add(key);
        ordered.add(newList);
        return ordered;
      }
    }

    for (String key : keys) {
      if (hm.get(key) > 0) {
        var newHm = updateHashMap(hm, key);
        System.out.println(newHm.toString());
        ArrayList<ArrayList<String>> x = buildString(newHm);
        x.stream().forEach(item -> {
          ArrayList<String> newItem = new ArrayList<>();
          newItem.addAll(item);
          ordered.add(item);
          newItem.add(key);
          ordered.add(newItem);
        });
      }
    }
    return ordered;
  }

  static private HashMap<String, Integer> updateHashMap(HashMap<String, Integer> hm, String item) {
    HashMap<String, Integer> newHm = new HashMap<>();
    newHm.putAll(hm);
    int num = newHm.get(item);
    if (num == 1) {
      newHm.remove(item);
    } else {
      newHm.put(item, num - 1);
    }
    return newHm;
  }
}
