import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] abcd = new int[4];
    Arrays.setAll(abcd, i -> sc.nextInt());
    System.out.println(abcd[0] * abcd[3] - abcd[1] * abcd[2]);

  }
}
