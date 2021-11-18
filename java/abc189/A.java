import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] abc = sc.next().split("");
    HashSet<String> hs = new HashSet<>();
    Arrays.stream(abc).forEach(s -> hs.add(s));
    if (hs.size() == 1) {
      System.out.println("Won");
    } else {
      System.out.println("Lost");
    }
  }
}
