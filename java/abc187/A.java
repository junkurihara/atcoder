import java.util.*;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = Arrays.stream(sc.next().split("")).map(s -> Integer.parseInt(s)).reduce(0, (acc, i) -> acc + i);
    int b = Arrays.stream(sc.next().split("")).map(s -> Integer.parseInt(s)).reduce(0, (acc, i) -> acc + i);

    System.out.println(Math.max(a, b));

  }

}
