import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    while (n % 10 == 0 && n != 0) {
      n /= 10;
    }
    String[] n_str_vec = Integer.toString(n).split("");
    String[] rev = new String[n_str_vec.length];
    for (int i = 0; i < n_str_vec.length; i++) {
      rev[i] = n_str_vec[n_str_vec.length - i - 1];
    }
    System.out.println(String.join("", rev));
    System.out.println(String.join("", n_str_vec));
    if (String.join("", n_str_vec).equals(String.join("", rev))) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

  }
}
