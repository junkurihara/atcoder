import java.util.*;

public class E {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
    for (int i = 0; i < m; i ++){
      int u = sc.nextInt();
      int v = sc.nextInt();
      var arrU = hm.getOrDefault(u, new ArrayList<Integer>());
      arrU.add(v);
      hm.put(u, arrU);
      var arrV = hm.getOrDefault(v, new ArrayList<Integer>());
      arrV.add(u);
      hm.put(v, arrV);
    }

    int div = 998244353;
    long cnt = 0;
    for (int i = 1; i < n+1; i++){

    }
    System.out.println(hm.toString());
  }
}
