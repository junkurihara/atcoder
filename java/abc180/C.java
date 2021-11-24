import java.util.*;

public class C {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long sqrt = (long) Math.ceil(Math.sqrt((double) n));
    HashSet<Long> hs = new HashSet<>();
    hs.add(1L);
    hs.add(n);

    for (long i = 2; i <= sqrt; i++) {
      if (n % i == 0) {
        hs.add(i);
        hs.add(n / i);
      }
    }
    hs.stream().sorted().forEach(i -> System.out.println(i));

  }

}
