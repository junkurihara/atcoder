import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String S = sc.next();
    String[] ss = S.split("");
    if (ss[0].equals(ss[1]) && ss[1].equals(ss[2])) {
      System.out.println(1);
    } else if (ss[0].equals(ss[1]) || ss[0].equals(ss[2]) || ss[1].equals(ss[2])) {
      System.out.println(3);
    } else {
      System.out.println(6);
    }

  }

}
