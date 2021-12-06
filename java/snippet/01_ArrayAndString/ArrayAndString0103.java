import java.util.*;
// 文字列内に出現する全ての空白文字を"%20"で置き換えるメソッドを書いてください。
// ただし、文字列の脳死路には新たに文字を追加するためのスペースが十分にある（バッファのサイズは気にしなくても良い）ここと、
// その追加用スペースを除いた文字列の真の長さが与えられます。
// （注意：Javaで実装する場合は、追加の領域を使用せずに処理できるよう文字配列を使ってください）
// 入力: "Mr John Smith ", 13
// 出力: "Mr%20John%20Smith"

public class ArrayAndString0103 {
  public static void main(String[] args) {
    char[] charArray = "abc def ghi jk             ".toCharArray();
    int len = 14;

    char[] replaced = replaceWhiteSpace(charArray, len);
    String x = "";
    for (char c : replaced) {
      x += String.format("%s", c);
    }
    System.out.println(x);
  }

  private static char[] replaceWhiteSpace(char[] charArray, int len) {
    int spaceCnt = 0;
    for (int i = 0; i < len; i++) {
      if (charArray[i] == ' ') {
        spaceCnt += 1;
      }
    }

    int index = len + spaceCnt * 2; // %20の20部分
    if (len < charArray.length) {
      charArray[len] = '\0';
    }
    for (int i = len - 1; i >= 0; i--) {
      if (charArray[i] == ' ') {
        charArray[index - 1] = '0';
        charArray[index - 2] = '2';
        charArray[index - 3] = '%';
        index -= 3;
      } else {
        charArray[index - 1] = charArray[i];
        index -= 1;
      }
    }
    return charArray;
  }
}
