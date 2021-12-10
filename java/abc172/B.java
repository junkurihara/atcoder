import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s = sc.next().split("");
    String[] t = sc.next().split("");
    int cnt = 0;
    for (int i = 0; i < s.length; i++) {
      cnt += (s[i].equals(t[i])) ? 0 : 1;
    }
    System.out.println(cnt);
  }
}
