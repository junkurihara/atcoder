import java.util.*;

// 二分木がBSTであるかどうかを調べる関数を実装してください

public class TreeGraph0405 {
  public static void main(String[] args) {
    int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
    Node root = createMinimalBST(arr);
    Node leaf = new Node(10);

    System.out.println(checkBST(root));
  }

  public static boolean checkBST(Node root) {
    if (root == null)
      return true;
    if (root.left != null && root.left.val >= root.val) {
      return false;
    }

    if (root.right != null && root.right.val <= root.val) {
      return false;
    }
    return checkBST(root.left) && checkBST(root.right);
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
