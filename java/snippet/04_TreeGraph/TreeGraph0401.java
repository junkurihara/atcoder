import java.util.*;

// 有向グラフが与えられたとき2つのノード間に経路があるかどうかを判定するアルゴリズムを設計してください
public class TreeGraph0401 {
  enum Status {
    Unvisited, Visited, Visiting;
  }

  boolean search(Graph g, Node start, Node end) {
    if (start == end) {
      return true;
    }

    // BFS
    Deque<Node> que = new LinkedList<>();
    for (Node u : g.getNodes()) {
      u.status = Status.Unvisited;
    }
    start.status = Status.Visited;
    que.add(start);
    while (!que.isEmpty()) {
      var next = que.pollFirst();
      if (next != null) {
        for (Node adj : next.getAdjacent()) {
          if (adj.status == Status.Unvisited) {
            if (adj == end) {
              return true;
            } else {
              adj.status = Status.Visiting;
              que.add(adj);
            }
          }
        }
        next.status = Status.Visited;
      }
    }
    return false;
  }

  class Node {
    public Status status;
    private Node[] adjacent;

    public Node[] getAdjacent() {
      return this.adjacent;
    }
  }

  class Graph {
    private Node[] nodes;

    public Node[] getNodes() {
      return this.nodes;
    }
  }

}
