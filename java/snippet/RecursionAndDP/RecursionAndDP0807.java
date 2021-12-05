import java.util.*;

// 文字が重複していない文字列の、すべての順列を計算するメソッドを書いてください。
//

public class RecursionAndDP0807 {
  public static void main(String[] args) {
    String[] stringArray = "abc".split("");
    ArrayList<ArrayList<String>> list = new ArrayList<>();
    list.add(new ArrayList<>());
    for (String s : stringArray) {
      list = updateOrdered(list, s);
    }

    list.stream().forEach(x -> {
      System.out.println(x.toString());
    });
  }

  static ArrayList<ArrayList<String>> updateOrdered(ArrayList<ArrayList<String>> list, String s) {
    ArrayList<ArrayList<String>> newList = new ArrayList<>();
    newList.addAll(list);

    list.stream().forEach(elem -> {
      for (int i = 0; i < elem.size() + 1; i++) {
        ArrayList<String> newElem = new ArrayList<>();
        newElem.addAll(elem);
        newElem.add(i, s);
        newList.add(newElem);
      }
    });

    return newList;
  }
}
