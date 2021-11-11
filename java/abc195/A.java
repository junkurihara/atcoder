import java.util.*;

public class A {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    // Queue<Integer> queue = new LinkedList<Integer>();
    int m = sc.nextInt();
    int h = sc.nextInt();

    if (h % m == 0) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
