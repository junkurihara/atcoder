import java.util.*;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    ArrayList<long[]> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      int ti = sc.nextInt();
      long[] tup = new long[2];
      Arrays.setAll(tup, j -> sc.nextLong());
      tup[0] = tup[0] * 10;
      tup[1] = tup[1] * 10;
      switch (ti) {
      case 1:
        list.add(tup);
        break;
      case 2:
        tup[1] -= 1;
        list.add(tup);
        break;
      case 3:
        tup[0] += 1;
        list.add(tup);
        break;
      case 4:
        tup[0] += 1;
        tup[1] -= 1;
        list.add(tup);
        break;
      }
    }
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
      for (int j = i + 1; j < N; j++) {
        if (Long.max(list.get(i)[0], list.get(j)[0]) <= Long.min(list.get(i)[1], list.get(j)[1])) {
          cnt += 1;
        }
      }
    }
    System.out.println(cnt);
  }
}
