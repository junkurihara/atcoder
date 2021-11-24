import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    String[] s_split = s.split("");
    if (s_split[s_split.length - 1].equals("s")) {
      System.out.println(s + "es");
      return;
    }
    System.out.println(s + "s");

  }
}
