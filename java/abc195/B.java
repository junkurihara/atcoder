import java.util.*;

public class B {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int w = sc.nextInt() * 1000;

    int r = w % a;
    int max_possible = (r == 0) ? w/a : (w-r)/a;
    r = w % b;
    int min_possible = (r == 0) ? w/b : (w-r)/b + 1;

    if (max_possible == 0 || min_possible == 0 || max_possible < min_possible ){
      System.out.println("UNSATISFIABLE");
    } else {
      System.out.println(min_possible + " " + max_possible);
    }
  }
}
