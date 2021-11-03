import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int sum = 21;
    for (int i = 0; i < 3; i++) {
      sum -= sc.nextInt();
    }
    System.out.println(sum);
  }
}
