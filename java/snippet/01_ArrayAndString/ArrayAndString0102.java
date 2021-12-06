import java.util.*;
// 2つの文字列が与えられた時、片方がもう片方の並び替えになっているかどうかを決定するメソッドを書いてください。
public class ArrayAndString0102 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] str1 = sc.next().split("");
    String[] str2 = sc.next().split("");

    if (str1.length != str2.length){
      System.out.println("No");
      return;
    }

    HashMap<String, Integer> hm = new HashMap<>();
    Arrays.stream(str1).forEach(s -> {
      int n = hm.getOrDefault(s, 0);
      hm.put(s, n+1);
    });

    for(String s : str2){
      var n = hm.getOrDefault(s, 0);
      if (n == 0){
        System.out.println("No");
        return;
      }
      hm.put(s, n - 1);
    }
    System.out.println("Yes");



  }
}
