import java.util.*;

// 二分木が平衡木かどうかを調べる関数を実装してください。
// 平衡木とはすべてのノードが持つ2つの部分木についてその高さの差が1以下であると定義します。

public class TreeGraph0404 {
  public static void main(String[] args) {
    int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
    Node root = createMinimalBST(arr);

    System.out.println(isBalanced(root));
  }

  public static int getHeight(Node root) {
    if (root == null)
      return -1;

    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

  public static boolean isBalanced(Node root) {
    if (root == null)
      return true;

    int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
    if (diff > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
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
    n.right = createMinimalBST(arr, mid + 1, end);
    return n;
  }

  static class Node {
    private int val;
    private Node left;
    private Node right;

    Node(int val) {
      this.val = val;
    }
  }
}
