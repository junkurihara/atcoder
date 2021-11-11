import java.util.*;

public class Search {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    Node[] graph = new Node[n];
    Arrays.setAll(graph, i -> new Node(i+1));

    for (int i = 0; i < m; i++){
      int parent = sc.nextInt();
      int child = sc.nextInt();
      graph[parent-1].connect(graph[child-1]);
    }
    int root_idx = sc.nextInt();
    int target_idx = sc.nextInt();
    boolean[] visited_DFS = new boolean[n];
    searchDFS(graph[root_idx - 1], visited_DFS, target_idx);

    boolean[] visited_BFS = new boolean[n];
    searchBFS(graph[root_idx - 1], visited_BFS, target_idx);
  }

  private static void searchBFS(Node root, boolean[] visited, int target){
    Deque<Node> que = new LinkedList<Node>();
    visited[root.idx - 1] = true;
    que.add(root);

    while (!que.isEmpty()){
      Node n = que.poll();
      System.out.println("Visit " + n.idx);
      if (n.idx == target){
        System.out.println("Found!");
        return;
      }
      for (Node adj : n.children){
        visited[adj.idx - 1] = true;
        que.add(adj);
      }
    }

  }


  private static void searchDFS(Node root, boolean[] stamps, int target){
    if (root == null) return;
    System.out.println("Visit " + root.idx);
    if (target == root.idx) {
      System.out.println("Found!");
      return;
    }
    stamps[root.idx - 1] = true;
    for (Node n : root.children){
      if (stamps[n.idx - 1] == false) {
        searchDFS(n, stamps, target);
      }
    }
  }
  /*
  6 5
  2 1
  2 3
  4 2
  4 5
  5 6
  4
  6
  // root 4
  // find 6
  */

  private static class Node {
    public int idx;
    public ArrayList<Node> children;
    Node(int idx){
      this.idx = idx;
      this.children = new ArrayList<Node>();
    }

    public void connect(Node child){
      children.add(child);
    }
  }
}
