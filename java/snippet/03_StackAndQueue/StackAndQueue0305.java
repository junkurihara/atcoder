import java.util.*;

// 最も小さい項目がトップに来るスタックを並び替えるプログラムを書いてください。
// 別のスタックを1つ用意しても構いません。
// スタック以外のデータ構造（配列など）にスタック上のコピーをしてはいけません。
// また、スタックは以下の操作のみ使用できます。
// push, pop, peek, isEmpty

public class StackAndQueue0305 {
  public static void main(String[] args) {
    int[] values = { 1, 2, 3, 4, 5, 6 };
    Stack<Integer> s1 = new Stack<>();
    for (int v : values) {
      s1.push(v);
    }
    System.out.println(s1.toString());
    var s2 = sort(s1);
    System.out.println(s2.toString());
  }

  static Stack<Integer> sort(Stack<Integer> orgStack) {
    Stack<Integer> newStack = new Stack<>();

    while (!orgStack.isEmpty()) {
      int tmp = orgStack.pop();
      while (!newStack.isEmpty() && newStack.peek() < tmp) {
        orgStack.push(newStack.pop());
      }
      newStack.push(tmp);
    }

    return newStack;
  }
}
