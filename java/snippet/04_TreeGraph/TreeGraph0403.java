import java.util.*;

// 2分探索木が与えられたとき同じ深さのノード同士の連結リストを作るアルゴリズムを設計してください。

public class TreeGraph0403 {
  public static void main(String[] args) {
    int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
    Node root = createMinimalBST(arr);

    ArrayList<LinkedList<Node>> levelList = new ArrayList<>();
    HashSet<Node> visited = new HashSet<>();
    updateLevelList(root, 0, levelList, visited);

    levelList.stream().forEach(x -> {
      x.stream().forEach(y -> {
        System.out.print(y.val + " ");
      });
    });

  }

  public static void updateLevelList(Node root, int currentLevel, ArrayList<LinkedList<Node>> list,
      HashSet<Node> visited) {
    if (root == null || visited.contains(root))
      return;

    if (list.size() <= currentLevel) {
      LinkedList<Node> newList = new LinkedList<>();
      newList.add(root);
      list.add(currentLevel, newList);
    } else {
      var existingList = list.get(currentLevel);
      existingList.add(root);
    }
    visited.add(root);
    updateLevelList(root.left, currentLevel + 1, list, visited);
    updateLevelList(root.right, currentLevel + 1, list, visited);
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
