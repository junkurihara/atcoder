import java.util.*;

// 古典的なハノイの塔の問題では、3つの塔とN枚のサイズの異なる円板を用いて塔の間を移動させます。
// 最初は円盤が下から上に向かって小さくなるようになっています。
// そして以下のような制約を持ちます。
// (1) 一度に１枚の円盤しか動かせない
// (2) 塔の一番上にある円板を他の塔に移動させる
// (3) 円盤はそれ自身より小さいものの上に置くことができない
// 最初の塔から最後に移動させるプログラムをスタックを用いて書いてください。

public class RecursionAndDP0806 {
  public static void main(String[] args) {
    int n = 10;
    Tower[] towers = new Tower[3];

    for (int i = 0; i < 3; i++) {
      towers[i] = new Tower(i);
    }
    for (int i = n - 1; i >= 0; i--) {
      towers[0].add(i);
    }

    towers[0].moveDisks(n, towers[2], towers[1]);
    for (Tower t : towers) {
      System.out.println(t.disks);
    }
  }

  static class Tower {
    public Stack<Integer> disks;
    private int idx;

    Tower(int i) {
      this.idx = i;
      this.disks = new Stack<>();
    }

    public void add(int d) {
      if (!this.disks.isEmpty() && this.disks.peek() <= d) {
        System.out.println("Error!");
        return;
      } else {
        disks.push(d);
      }
    }

    public void moveTopTo(Tower t) {
      int top = this.disks.pop();
      t.add(top);
    }

    public void moveDisks(int n, Tower dest, Tower buf) {
      if (n > 0) {
        this.moveDisks(n - 1, buf, dest);
        this.moveTopTo(dest);
        buf.moveDisks(n - 1, dest, this);
      }
    }
  }
}
