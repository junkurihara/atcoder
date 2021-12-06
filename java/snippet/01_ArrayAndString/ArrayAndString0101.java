import java.util.*;
// ある文字列が全て固有である（重複する文字がない）可動化を判定するアルゴリズムを実装してください。
// またそれを実装するのに新たなデータ構造が使えない場合、どのようにすれば良いですか？

public class ArrayAndString0101 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();

    // Assumed that the given string is in ASCII
    if(str.length() > 128){
      System.out.println("No");
      return;
    }

    boolean[] appeared = new boolean[128];
    for(int i=0; i < str.length(); i++){
      if(appeared[str.charAt(i)]){
        System.out.println("No");
        return;
      }
      appeared[str.charAt(i)] = true;
    }

    System.out.println("Yes");
  }
}
