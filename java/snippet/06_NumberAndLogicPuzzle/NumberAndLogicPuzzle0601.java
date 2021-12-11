import java.util.*;

// 20個の瓶にそれぞれ錠剤が入っています。
// そのうち19個の瓶には1.0グラムの錠剤が、残り1個の瓶には1.1グラムの錠剤が入っています。
// 重さを正確に図ることのできる測りが与えられた時、どうやって重い錠剤の入った瓶を見つけますか？
// ただし、測りは1度しか使うことができません。
public class NumberAndLogicPuzzle0601 {
  public static void main(String[] args) {
    double[] setup = {
        1.0, 1.0, 1.0, 1.0, 1.0,
        1.0, 1.1, 1.0, 1.0, 1.0,
        1.0, 1.0, 1.0, 1.0, 1.0,
        1.0, 1.0, 1.0, 1.0, 1.0
    };

    BlindBottles bottles = new BlindBottles(setup);
    int sum = bottles.calcSum10();
    int expected = 10 * 20 * 21 / 2;
    int idx = sum - expected;
    System.out.println("Heavier bottle idx is " + idx);
  }
}

class BlindBottles {
  private double[] weights;

  BlindBottles(double[] setup) {
    this.weights = setup;
  }

  public int calcSum10() {
    int sum = 0;
    for (int i = 0; i < this.weights.length; i++) {
      sum += (i + 1) * (int) (weights[i] * 10);
      System.out.println((i + 1) * weights[i]);
    }
    return sum;
  }
}
