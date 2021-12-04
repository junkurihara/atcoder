import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s = sc.next().split("");
    int startIdx = 0;
    for (int i = 0; i < Math.min(3, s.length); i++) {
      if (s[i].equals("o")) {
        startIdx = i;
        break;
      } else if (!(s[i].equals("x"))) {
        System.out.println("No");
        return;
      }
    }
    if (startIdx == 0 && s[0] != "o") {
      if (s.length >= 3) {
        System.out.println("No");
        return;
      }
      startIdx = 3 + s.length;
    }

    String[] sample = "oxx".split("");

    for (int i = startIdx; i < s.length; i++) {
      if (!(s[i].equals(sample[(i - startIdx) % sample.length]))) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }

}
