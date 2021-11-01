import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    Arrays.setAll(A, i -> sc.nextInt());
    HashSet<Integer> hs = new HashSet<>();
    for (Integer a : A) {
      hs.add(a);
    }
    if (hs.size() == N && hs.contains(1)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    // System.out.println(Arrays.toString(A));

  }
}
