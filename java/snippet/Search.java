import java.util.*;

public class Search {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    Node[] graph = new Node[n];
    Arrays.setAll(graph, i -> new Node(i + 1));

    for (int i = 0; i < m; i++) {
      int parent = sc.nextInt();
      int child = sc.nextInt();
      graph[parent - 1].connect(graph[child - 1]);
    }
    int root_idx = sc.nextInt();
    int target_idx = sc.nextInt();

    HashSet<Integer> visited_DFS = new HashSet<>();
    searchDFS(graph[root_idx - 1], visited_DFS, target_idx);

    HashSet<Integer> visited_BFS = new HashSet<>();
    searchBFS(graph[root_idx - 1], visited_BFS, target_idx);
  }

  private static void searchBFS(Node root, HashSet<Integer> visited, int target) {
    Deque<Node> que = new LinkedList<Node>();
    visited.add(root.idx - 1);
    que.add(root);

    while (!que.isEmpty()) {
      Node n = que.poll();
      System.out.println("Visit " + n.idx);
      if (n.idx == target) {
        System.out.println("Found!");
        return;
      }
      for (Node adj : n.children) {
        visited.add(adj.idx - 1);
        que.add(adj);
      }
    }

  }

  // private static void searchDFS(Node root, boolean[] stamps, int target) {
  private static void searchDFS(Node root, HashSet<Integer> stamps, int target) {
    if (root == null)
      return;
    System.out.println("Visit " + root.idx);
    if (target == root.idx) {
      System.out.println("Found!");
      return;
    }
    stamps.add(root.idx - 1);
    for (Node n : root.children) {
      if (!stamps.contains(n.idx - 1)) {
        searchDFS(n, stamps, target);
      }
    }
  }
  /*
   * 6 5 2 1 2 3 4 2 4 5 5 6 4 6 // root 4 // find 6
   */

  private static class Node {
    public int idx;
    public ArrayList<Node> children;

    Node(int idx) {
      this.idx = idx;
      this.children = new ArrayList<Node>();
    }

    public void connect(Node child) {
      children.add(child);
    }
  }
}
