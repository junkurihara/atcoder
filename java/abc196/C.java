import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] n = sc.next().split("");
    int len = (n.length - (n.length % 2)) / 2;
    if (n.length % 2 == 1) {
      System.out.println((int) Math.pow(10, len) - 1);
    } else {
      int former = Integer.parseInt(String.join("", Arrays.copyOfRange(n, 0, len)));
      int latter = Integer.parseInt(String.join("", Arrays.copyOfRange(n, len, len * 2)));

      if (former > latter) {
        System.out.println(former - 1);
      } else {
        System.out.println(former);
      }

    }

  }
}
