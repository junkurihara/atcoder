import java.util.*;

// 昇順にソートされたすべての要素が異なる配列が与えられたとき、高さが最小になる2分探索木を作るアルゴリズムを書いてください。
public class TreeGraph0402 {
  public static void main(String[] args) {
    int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
    Node root = createMinimalBST(arr);

    Deque<Node> deq = new LinkedList<>();
    HashSet<Node> visited = new HashSet<>();
    deq.addLast(root);

    while (!deq.isEmpty()) {
      var current = deq.pollFirst();
      visited.add(current);
      if (current.left != null && !visited.contains(current.left)) {
        deq.addLast(current.left);
      }
      if (current.right != null && !visited.contains(current.right)) {
        deq.addLast(current.right);
      }
      System.out.println(current.val);
    }
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
