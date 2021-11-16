import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Char {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] words = sc.next().chars().toArray();
    int[] flag = new int[26];

    int base = "a".chars().toArray()[0];
    for (int c : words) {
      int c_int = c - base;
      flag[c_int] += 1;
    }

    System.out.println("duplicate? " + Arrays.stream(flag).anyMatch(x -> x > 1));

    checkCircular(words);

  }

  public static void checkCircular(int[] chars) {
    HashMap<Integer, Integer> cnt = new HashMap<>();
    for (int c : chars) {
      var local_cnt = cnt.getOrDefault(c, 0);
      cnt.put(c, local_cnt + 1);
    }
    int wc = chars.length;
    if (wc % 2 == 0) {
      System.out.println("circular? " + cnt.values().stream().allMatch(x -> x % 2 == 0));
    } else {
      List<Integer> odd = cnt.values().stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
      System.out
          .println("circular? " + (odd.size() == 1 && cnt.values().stream().allMatch(x -> x % 2 == 0 || x % 2 == 1)));
    }

  }
}
