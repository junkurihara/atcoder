import java.util.*;

// 単方向連結リストにおいて、間の要素（必ずしもちょうど中央というわけではなく、最初と最後の要素以外）
// で、その要素のみアクセス可能であるとします。その要素を削除するアルゴリズムを実装してください。
// 入力 a->b->c->d->e->fという連結リストが与えられます。
// 出力 何も返しませんが、リストはa->b->d->e->fのように見えます。

public class LinkedList0203 {
  public static void main(String[] args) {
    String[] values = { "a", "b", "c", "d", "e", "f" };
    String target = "c";
    Node[] nodes = new Node[6];

    nodes[5] = new Node(values[5]);
    for (int i = 4; i >= 0; i--) {
      nodes[i] = new Node(values[i]);
      nodes[i].setNext(nodes[i + 1]);
    }
    System.out.println(deleteNode(nodes, nodes[2]));
  }

  static boolean deleteNode(Node[] list, Node target) {
    if (target == null || target.next == null) {
      return false;
    }
    var nextNode = target.next;
    target.val = nextNode.val;
    target.next = nextNode.next;
    return true;
  }

  static class Node {
    public String val;
    public Node next;

    Node(String val) {
      this.val = val;
    }

    public void setNext(Node n) {
      this.next = n;
    }
  }
}
