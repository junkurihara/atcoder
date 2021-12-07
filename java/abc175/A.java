import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s = sc.next().split("");
    int numR = 0;
    for (String x : s) {
      if (x.equals("R")) {
        numR += 1;
      }
    }

    if (s[1].equals("R") && numR >= 2) {
      System.out.println(numR);
    } else if (numR >= 1) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
}
