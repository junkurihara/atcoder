import java.util.*;

// ある数xが与えられた時、連結リストの要素を並び替え、xより小さいものが前に来るようにするコードを書いてください。
// xがリストに含まれる場合、xの値はxより小さい要素の後にある必要があります。
// 区切り要素のxの値は右半分のどこに現れても構いません。左半分と右半分のちょうど間にある必要はないということです。
// 入力 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 (区切り要素=5)
// 出力 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

public class LinkedList0204 {
  public static void main(String[] args) {
    int[] values = { 3, 5, 8, 5, 10, 2, 1 };
    int target = 5;
    Node[] nodes = new Node[values.length];

    nodes[0] = new Node(values[0]);
    for (int i = 1; i < values.length; i++) {
      nodes[i] = new Node(values[i]);
      nodes[i - 1].next = nodes[i];
    }
    var newNode = partition(nodes[0], target);
    while (newNode != null) {
      System.out.println(newNode.val);
      newNode = newNode.next;
    }
  }

  static Node partition(Node root, int target) {
    Node beforeStart = null;
    Node beforeEnd = null;
    Node afterStart = null;
    Node afterEnd = null;

    while (root != null) {
      Node next = root.next;
      root.next = null;
      if (root.val < target) {
        if (beforeStart == null) {
          beforeStart = root;
          beforeEnd = beforeStart;
        } else {
          beforeEnd.next = root;
          beforeEnd = root;
        }
      } else {
        if (afterStart == null) {
          afterStart = root;
          afterEnd = afterStart;
        } else {
          afterEnd.next = root;
          afterEnd = root;
        }
      }
      root = next;
    }

    if (beforeStart == null) {
      return afterStart;
    }
    beforeEnd.next = afterStart;
    return beforeStart;
  }

  static class Node {
    public int val;
    public Node next;

    Node(int val) {
      this.val = val;
    }

    public void setNext(Node n) {
      this.next = n;
    }
  }
}
