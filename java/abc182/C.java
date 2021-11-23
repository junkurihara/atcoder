import java.util.*;
import java.util.stream.Collectors;

public class C {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> n = new ArrayList<String>(Arrays.stream(sc.next().split("")).collect(Collectors.toList()));

    Calc c = new Calc();
    c.compute(n);
  }

  static class Calc {
    private HashSet<Integer> ord;

    Calc() {
      this.ord = new HashSet<>();
    }

    public void compute(ArrayList<String> n) {
      for (int i = 0; i < n.size(); i++) {
        this.calc(n, i);
      }
      if (ord.size() > 0) {
        System.out.println(n.size() - ord.stream().mapToInt(x -> x).max().getAsInt());
      } else {
        System.out.println(-1);
      }
    }

    private void calc(ArrayList<String> arr, int rmv) {
      if (rmv == 0) {
        String num_str = arr.stream().collect(Collectors.joining());
        if (Long.parseLong(num_str) % 3 == 0) {
          this.ord.add(num_str.length());
        }
        return;
      }
      for (int i = 0; i < arr.size(); i++) {
        if (!this.ord.contains(arr.size())) {
          ArrayList<String> new_arr = new ArrayList<>(arr);
          new_arr.remove(i);
          calc(new_arr, rmv - 1);
        }
      }
    }
  }

}
