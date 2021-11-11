import java.util.*;

public class D {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] ab = new int[n][2];
    Arrays.setAll(ab, j -> {
      int x[] = new int[2];
      x[0] = sc.nextInt();
      x[1] = sc.nextInt();
      return x;
    });

    HashSet<String> hs = new HashSet<>();
    for (int i = 0 ; i < n; i++){
      for (int j = i+1 ; j < n; j++){
        int[] forward = {ab[j][0] - ab[i][0], ab[j][1] - ab[i][1]};
        int[] reverse = {ab[i][0] - ab[j][0], ab[i][1] - ab[j][1]};
        int both_gcm = (forward[0] != 0 && forward[1] != 0)
          ? gcd(Math.abs(forward[0]), Math.abs(forward[1]))
          : Math.abs(forward[0]+forward[1]);
        forward[0] /= both_gcm;
        forward[1] /= both_gcm;
        reverse[0] /= both_gcm;
        reverse[1] /= both_gcm;
        hs.add(forward[0] + " " + forward[1]);
        hs.add(reverse[0] + " " + reverse[1]);
      }
    }

    System.out.println(hs.size());
  }

  private static int gcd (int a, int b) {
    return (a % b == 0) ? b : gcd(b, a % b);
  }
}
