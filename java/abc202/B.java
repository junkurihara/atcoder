import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    String[] array_s = s.split("");

    HashMap<String, String> lookup = new HashMap<>() {
      {
        put("0", "0");
        put("1", "1");
        put("6", "9");
        put("8", "8");
        put("9", "6");
      }
    };
    int i = 0;
    for (String c : array_s) {
      var newC = lookup.get(c);
      array_s[i] = newC;
      i += 1;
    }
    Collections.reverse(Arrays.asList(array_s));

    System.out.println(String.join("", array_s));
  }
}
