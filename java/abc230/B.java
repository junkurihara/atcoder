import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s = sc.next().split("");

    int startIdx = -1;
    for (int i = 0; i < Math.min(3, s.length); i++) {
      if (s[i].equals("o")) {
        startIdx = i;
        break;
      } else if (!s[i].equals("x")) {
        System.out.println("No");
        return;
      }
    }
    if (startIdx == -1) {
      if (s.length >= 3) {
        System.out.println("No");
        return;
      } else {
        System.out.println("Yes");
        return;
      }
    }

    String[] sample = "oxx".split("");

    for (int i = startIdx; i < s.length; i++) {
      if (!sample[(i - startIdx) % 3].equals(s[i])) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");

  }

}
