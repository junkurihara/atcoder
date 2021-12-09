import java.util.*;

// 皿が積み上がっている状況をイメージしてください。
// もし、高く積み上がりすぎたら倒れてしまうでしょう。
// ですから、実生活ではスタックがある領域を超えた時、新しいスタックを用意することになるでしょう。
// これを真似たデータ構造SetOfStacksを実装してください。
// SetOfStacksはいくつかのスタックを持ち、スタックのデータがいっぱいになったらスタックを新たに作らなければなりません。
// また、SetOfStacks.push()とSetOfStacks.popは普通のスタックのように振る舞うようにしてください。
// (つまり、pop()は通常の1つのスタックの場合と同じ値を返さなければなりません)
// 発展問題：任意の部分スタックからpopする関数popAt(int index)を実装してください。

abstract public class StackAndQueue0303 {
  public static void main(String[] args) {
    int[] vals = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    SetOfStacks sos = new SetOfStacks();
    for (int v : vals) {
      sos.push(v);
    }

    for (int i = 0; i < 5; i++) {
      System.out.println(sos.pop() + " " + sos.stacks.size());
    }

    sos.printStacks();

    sos.popAt(0);
    sos.printStacks();
  }

}

class SetOfStacks {
  private final int maxSize = 3;
  public ArrayList<Deque<Integer>> stacks = new ArrayList<>();

  public void push(int val) {
    Deque<Integer> target = this.getLastStack();
    if (target.size() == this.maxSize) {
      target = new LinkedList<Integer>();
      this.stacks.add(target);
    }
    target.push(val);
  }

  private Deque<Integer> getLastStack() {
    if (this.stacks.size() == 0) {
      this.stacks.add(new LinkedList<Integer>());
    }
    return this.stacks.get(this.stacks.size() - 1);
  }

  private void dropLastStack() throws EmptyStackException {
    if (this.stacks.size() == 0) {
      throw new EmptyStackException();
    }
    this.stacks.remove(this.stacks.size() - 1);
  }

  public int pop() {
    Deque<Integer> target = this.getLastStack();
    while (target.size() == 0) {
      this.dropLastStack();
      target = this.getLastStack();
    }
    int v = target.pop();
    return v;
  }

  public int popAt(int i) throws EmptyStackException {
    if (i > this.stacks.size() - 1 || i < 0) {
      throw new EmptyStackException();
    }
    Deque<Integer> target = this.stacks.get(i);
    int v = target.pop();
    for (int ptr = i; ptr < this.stacks.size() - 1; ptr++) {
      Deque<Integer> to = this.stacks.get(ptr);
      Deque<Integer> from = this.stacks.get(ptr + 1);
      if (from.size() != 0) {
        var x = from.pollLast();
        to.addFirst(x);
      }
      if (from.size() == 0) {
        this.stacks.remove(ptr + 1);
      }
    }
    return v;
  }

  public void printStacks() {

    System.out.println(this.stacks.toString());

  }
}
