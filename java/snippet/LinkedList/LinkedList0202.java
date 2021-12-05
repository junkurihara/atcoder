import java.util.*;

// 単方向連結リストにおいて、末尾から数えてk番目の要素を見つけるアルゴリズムを実装してください。

public class LinkedList0202 {
  public int recursive(LinkedListNode node, int k) {
    if (node == null) {
      return 0;
    }
    int index = recursive(node.next, k) + 1;
    if (index == k) {
      System.out.println(node.value);
    }
    return index;
  }

  public void loop(LinkedListNode firstNode, int k) {
    LinkedListNode p1 = firstNode;
    LinkedListNode p2 = firstNode;
    for (int i = 0; i < k; i++) {
      if (p1 == null)
        return;
      p1 = p1.next;
    }

    while (p1 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    System.out.println(p2.value);
  }

  class LinkedListNode {
    public int value;
    public LinkedListNode next;
  }
}
