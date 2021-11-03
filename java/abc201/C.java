import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    Set<Integer> hs_inc = new HashSet<>();
    Set<Integer> hs_notinc = new HashSet<>();

    for (int i = 0; i < 10; i++) {
      if (s.charAt(i) == 'o') {
        hs_inc.add(i);
      } else if (s.charAt(i) == 'x') {
        hs_notinc.add(i);
      }
    }

    int cnt = 0;
    for (int num = 0; num < 10000; num++) {
      Set<Integer> hs = new HashSet<>();
      int ones = num % 10;
      int tens = ((num - ones) % 100) / 10;
      int hundreds = ((num - tens * 10 - ones) % 1000) / 100;
      int thousands = (num - hundreds * 100 - tens * 10 - ones) / 1000;
      hs.add(ones);
      hs.add(tens);
      hs.add(hundreds);
      hs.add(thousands);
      Set<Integer> intersection1 = new HashSet<>(hs_inc);
      Set<Integer> intersection2 = new HashSet<>(hs_notinc);
      intersection1.retainAll(hs);
      intersection2.retainAll(hs);

      if (intersection1.size() == hs_inc.size() && intersection2.isEmpty()) {
        cnt += 1;
      }

    }
    System.out.println(cnt);
  }
}
