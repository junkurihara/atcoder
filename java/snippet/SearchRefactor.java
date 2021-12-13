import java.util.*;

public class SearchRefactor {
  public static void main(String[] args) {
    // nodes = 6
    // (parent, child)
    int[][] pc = {
        { 2, 1 },
        { 2, 3 },
        { 4, 2 },
        { 4, 5 },
        { 5, 6 }
    };
    int n = 6;
    int targetVal = 6;
    ArrayList<BTNode<Integer>> nodes = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      nodes.add(new BTNode(i + 1));
    }

    for (int[] x : pc) {
      var parent = nodes.get(x[0] - 1);
      var child = nodes.get(x[1] - 1);
      if (nodes.get(x[0] - 1).left == null) {
        parent.left = child;
      } else {
        parent.right = child;
      }
      child.parent = parent;
    }
    var roots = nodes.stream().filter(x -> x.parent == null).toList();
    if (roots.size() != 1)
      return;
    var root = roots.get(0);
    HashSet<Integer> visited = new HashSet<>();
    searchDfs(root, targetVal, visited);
    searchBfs(root, targetVal);
    // System.out.println(root.value);
    // nodes.stream().forEach(nn -> System.out.println(nn.value + " " + nn.parent +
    // " " + nn.left + " " + nn.right));

  }

  public static <T> void searchBfs(BTNode<T> root, T targetValue) {
    HashSet<T> visited = new HashSet<>();
    Deque<BTNode<T>> que = new LinkedList<>();
    que.push(root);

    while (!que.isEmpty()) {
      var visiting = que.pop();
      System.out.println("Visiting node " + visiting.value);
      if (visiting.value.equals(targetValue)) {
        System.out.println("Found!");
        break;
      }
      visited.add(visiting.value);
      if (visiting.left != null)
        que.add(visiting.left);
      if (visiting.right != null)
        que.add(visiting.right);
    }
  }

  public static <T> void searchDfs(BTNode<T> node, T targetValue, HashSet<T> visited) {
    if (node == null) {
      return;
    }
    System.out.println("Visiting node" + node.value);
    if (node.value.equals(targetValue)) {
      System.out.println("Found!");
      return;
    }
    visited.add(node.value);
    if (!visited.contains(node.left)) {
      searchDfs(node.left, targetValue, visited);
    }
    if (!visited.contains(node.right)) {
      searchDfs(node.right, targetValue, visited);
    }
  }
}

class BTNode<T> {
  public T value;
  public BTNode<T> parent;
  public BTNode<T> left;
  public BTNode<T> right;

  BTNode(T val) {
    this.value = val;
  }
}
