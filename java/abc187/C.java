import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    HashSet<String> hs = new HashSet<>();
    for (int i = 0; i < n; i++) {
      String s = sc.next();
      hs.add(s);
      String[] s_split = s.split("");
      if (s_split[0].equals("!")) {
        String truncated_s = String.join("", Arrays.copyOfRange(s_split, 1, s_split.length));
        if (hs.contains(truncated_s)) {
          System.out.println(truncated_s);
          return;
        }
      } else {
        if (hs.contains("!" + s)) {
          System.out.println(s);
          return;
        }
      }

    }
    System.out.println("satisfiable");

  }

}
