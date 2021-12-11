import java.util.*;

public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    Node[] nodes = new Node[n];
    Arrays.setAll(nodes, i -> new Node(i + 1));
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      if (nodes[a - 1].conn.size() >= 2 || nodes[b - 1].conn.size() >= 2) {
        System.out.println("No");
        return;
      }
      nodes[a - 1].conn.add(nodes[b - 1]);
      nodes[b - 1].conn.add(nodes[a - 1]);
    }

    HashSet<Integer> visited = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (!visited.contains(i + 1)) {
        boolean res = isUnloop(nodes[i], null, visited, nodes[i]);
        // System.out.println(res);
        if (!res) {
          System.out.println("No");
          return;
        }
      }
    }
    System.out.println("Yes");

  }

  static boolean isUnloop(Node current, Node previous, HashSet<Integer> visited, Node target) {
    // System.out.println("visiting " + current.val);

    visited.add(current.val);
    boolean res = true;
    for (Node i : current.conn) {
      if (target.equals(i) && !previous.equals(target)) {
        return false;
      }
      if (!i.equals(previous) && !visited.contains(i.val)) {
        res = res && isUnloop(i, current, visited, target);
      }
    }
    return res;

  }

}

class Node {
  public int val;
  public ArrayList<Node> conn;

  Node(int v) {
    this.val = v;
    this.conn = new ArrayList<>();
  }
}
