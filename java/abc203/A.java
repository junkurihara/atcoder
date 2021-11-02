import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] abc = new int[3];
    Arrays.setAll(abc, i -> sc.nextInt());

    Arrays.sort(abc);

    if (abc[0] == abc[1]) {
      System.out.println(abc[2]);
    } else if (abc[1] == abc[2]) {
      System.out.println(abc[0]);
    } else {
      System.out.println(0);
    }

  }
}
