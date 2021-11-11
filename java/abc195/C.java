import java.util.*;

public class C {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    int ord = 0;
    for (int i = 0; i < 16; i++){
      if (Math.floor((double) n / Math.pow(10.0, (double) i)) > 0) {
        ord += 1;
      } else {
        break;
      }
    }

    if (n < 1000) {
      System.out.println(0);
    } else {
      int maxnum = (ord - 1 - ((ord - 1) % 3))/ 3;
      long cnt = 0;
      for (int i = 0; i < maxnum; i++){
        cnt += n - ((long) Math.pow(1000.0, (double) i + 1.0 ) - 1);
      }
      System.out.println(cnt);
    }
  }
}
