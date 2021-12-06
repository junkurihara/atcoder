import java.util.*;

// 2分探索木において、与えられたノードの「次の」ノード(in-orderの操作で)を探すアルゴリズムを書いてください。
// 各ノードは自身の親ノードへのリンクを持っていると仮定して構いません

public class TreeGraph0406 {
  public static void main(String[] args) {
    int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
    Node root = createMinimalBST(arr);
    System.out.println(root.right.right.val);
    System.out.println(root.right.right.left);
    System.out.println(root.right.right.right);
    System.out.println(searchNextNode(root.right.right).val);
  }

  public static Node searchDeepestLeftNode(Node n) {
    if (n.left == null)
      return n;
    return searchDeepestLeftNode(n.left);
  }

  public static Node searchNextNode(Node n) {
    if (n.right != null)
      return searchDeepestLeftNode(n.right);

    if (n.parent != null) {
      if (n.parent.left == n) {
        return n.parent;
      }
      return searchNextNode(n.parent);
    }
    return null;

  }

  public static Node createMinimalBST(int[] arr) {
    return createMinimalBST(arr, 0, arr.length - 1, null);
  }

  public static Node createMinimalBST(int[] arr, int start, int end, Node parent) {
    if (end < start)
      return null;

    var mid = (int) (start + end) / 2;
    Node n = new Node(arr[mid], parent);
    n.left = createMinimalBST(arr, start, mid - 1, n);
    n.right = createMinimalBST(arr, mid + 1, end, n);
    return n;
  }

  static class Node {
    private int val;
    private Node left;
    private Node right;
    private Node parent;

    Node(int val, Node parent) {
      this.val = val;
      this.parent = parent;
    }
  }
}
