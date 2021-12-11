import java.util.*;

public class C {
  final long MAX_N = 1_000_000_000_000_001L;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    String[] words = "abcdefghijklmnopqrstuvwxyz".split("");

    String output = "";
    while (n > 0) {
      output = words[(int) ((n - 1) % 26)] + output;
      n = ((n - 1) - ((n - 1) % 26)) / 26;
    }
    System.out.println(output);
  }
}
