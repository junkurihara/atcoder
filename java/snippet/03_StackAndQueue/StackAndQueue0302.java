import java.util.*;

// pushとpopに加えて最小の要素を返す関数minを持つスタックをどのようにデザインしますか？
// ただし、push, pop, min関数はすべてO(1)の実行時間になるようにしてください。

public class StackAndQueue0302 {
  public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
      int newMin = Main.min(value, this.min());
      super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
      if (this.isEmpty()) {
        return Integer.MAX_VALUE;
      }
      return this.peek().min;
    }

    public int pop_val() {
      var node = super.pop();
      return node.value;
    }
  }

  class NodeWithMin {
    public int value;
    public int min;

    NodeWithMin(int v, int min) {
      this.value = v;
      this.min = min;
    }
  }

  public class StackWithMin2 extends Stack<Integer> {
    private Stack<Integer> stackMinValues;

    StackWithMin2() {
      this.stackMinValues = new Stack<Integer>();
    }

    public void push(int value) {
      if (this.min() >= value) {
        stackMinValues.push(value);
      }
      super.push(value);
    }

    public Integer pop() {
      int val = super.pop();
      if (val == this.min())
        this.stackMinValues.pop();

      return val;
    }

    public int min() {
      if (stackMinValues.isEmpty)
        return Integer.MAX_VALUE;
      return stackMinValues.peek();
    }
  }
}
