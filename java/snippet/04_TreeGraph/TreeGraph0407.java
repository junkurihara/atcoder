import java.util.*;

// 実行順序:
// プロジェクトのリストと依存関係(プロジェクトのペアで、1番目のプロジェクトは2番目のプロジェクトに依存する)のリストが与えられます。
// 依存関係のあるプロジェクトは、そのプロジェクトの前にすべて完成しなければいけません。
// このとき、実行可能なプロジェクトの順序を見つけてください。そのような順序づけが不可能な場合はエラーを返してください。
// 例: 入力
//    プロジェクト: a,b,c,d,e,f
//    依存関係: (d, a), (b, f), (d, b), (a, f), (c, d)
//    出力: f, e, a, b, d, c

public class TreeGraph0407 {
  public static void main(String[] args) {
    String[] projectNames = { "a", "b", "c", "d", "e", "f" };
    String[][] dependsOn = {
        { "d", "a" }, { "b", "f" }, { "d", "b" }, { "a", "f" }, { "c", "d" }
    };

    HashMap<String, Node> projects = new HashMap<>();
    for (String name : projectNames) {
      projects.put(name, new Node(name));
    }
    for (String[] dependent : dependsOn) {
      var node = projects.get(dependent[0]);
      node.dependsOn(projects.get(dependent[1]));
    }

    HashMap<String, Node> alreadyCompiled = new HashMap<>();
    ArrayList<Node> ordered = new ArrayList<>();
    var projectSize = projects.size();
    while (projects.size() > 0) {
      for (String name : projects.keySet().stream().toList()) {
        var node = projects.get(name);
        if (canBeCompiled(node, alreadyCompiled)) {
          alreadyCompiled.put(name, node);
          ordered.add(node);
          projects.remove(name);
        }
      }
      if (projectSize == projects.size()) {
        System.out.println("No");
      }
    }
    for (Node node : ordered) {
      System.out.println(node.name);
    }
  }

  public static boolean canBeCompiled(Node node, HashMap<String, Node> alreadyCompiled) {
    var dependsOn = node.getDependent();
    for (Node dependent : dependsOn) {
      if (!alreadyCompiled.containsKey(dependent.name)) {
        return false;
      }
    }
    return true;
  }

  static class Node {
    private String name;
    private ArrayList<Node> parents;

    Node(String name) {
      this.name = name;
      this.parents = new ArrayList<>();
    }

    public void dependsOn(Node node) {
      this.parents.add(node);
    }

    public ArrayList<Node> getDependent() {
      return this.parents;
    }
  }
}
