import java.util.*;

// 二分木において、2つのノードの上位ノードで最初に共通するものを探すアルゴリズムを設計し、コードを書いてください。
// ただし、データ構造の中に新たにノードを追加してはいけません（二分木は二分探索木とは限りません）

public class TreeGraph0408 {
  public static void main(String[] args) {
    int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
    Node root = createMinimalBST(arr);
    Node node1 = root.left.right;
    Node node2 = root.left.left;

    System.out.println(node1.val);
    System.out.println(node2.val);
    // System.out.println(checkBST(root));
    Node commonNode = searchCommonParent(node1, node2);
    System.out.println(commonNode.val);
  }

  public static Node searchCommonParent(Node n1, Node n2) {
    int diff = getDepth(n1) - getDepth(n2);
    Node shallow = diff > 0 ? n2 : n1;
    Node deep = diff > 0 ? n1 : n2;
    deep = goUpBy(deep, Math.abs(diff));

    while (deep != shallow && deep != null && shallow != null) {
      shallow = shallow.parent;
      deep = deep.parent;
    }
    return (deep != null && shallow != null) ? deep : null;
  }

  private static Node goUpBy(Node n, int diff) {
    while (diff > 0 && n != null) {
      n = n.parent;
      diff--;
    }
    return n;
  }

  private static int getDepth(Node n) {
    int depth = 0;
    while (n != null) {
      n = n.parent;
      depth++;
    }
    return depth;
  }

  public static Node createMinimalBST(int[] arr) {
    return createMinimalBST(arr, 0, arr.length - 1);
  }

  public static Node createMinimalBST(int[] arr, int start, int end) {
    if (end < start)
      return null;

    var mid = (int) (start + end) / 2;
    Node n = new Node(arr[mid]);
    n.left = createMinimalBST(arr, start, mid - 1);
    if (n.left != null)
      n.left.parent = n;
    n.right = createMinimalBST(arr, mid + 1, end);
    if (n.right != null)
      n.right.parent = n;
    return n;
  }

  static class Node {
    private int val;
    private Node parent;
    private Node left;
    private Node right;

    Node(int val) {
      this.val = val;
    }
  }
}
