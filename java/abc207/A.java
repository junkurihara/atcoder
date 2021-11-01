import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // int N = sc.nextInt();
    int[] abc = new int[3];
    Arrays.setAll(abc, i -> sc.nextInt());
    Arrays.sort(abc);

    System.out.println(abc[1] + abc[2]);
  }
}
