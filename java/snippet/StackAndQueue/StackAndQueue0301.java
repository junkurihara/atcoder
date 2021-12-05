import java.util.*;

// 1つの配列を使って3つのスタックを実装するにはどうすれば良いのか述べてください

public class StackAndQueue0301 {
  public class FixedMultiStack {
    private int numStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMutliStack(int stackSize){
      this.stackCapacity = stackSize;
      this.values = new int[StackSize * this.numStacks];
      this.sizes = new int[this.numStacks];
    }

    public void push(int stackId, int value) throws FullStackException {
      if (this.isFull(stackId)) {
        throw new FullStackException();
      }

      this.sizes[stackId] += 1;
      values[getTopIdx(stackId)] = value;
    }

    public int pop(int stackId) throws EmptyStackException {
      if (this.isEmpty(stackId)) {
        throw new EmptyStackException();
      }

      int idx = this.getTopIdx(stackId);
      int val = this.values[idx];
      this.values[idx] = 0;
      this.size[stackId] -= 1;
      return val;
    }

    public int peek(int stackId) throws EmptyStackException {
      if (this.isEmpty(stackId)) {
        throw new EmptyStackException();
      }

      int idx = this.getTopIdx(stackId);
      return this.values[idx];
    }

    private int getTopIdx(int stackId) {
      int offset = stackId * this.stackCapacity;
      int size = this.sizes[stackId];
      return offset + size - 1;
    }

    private boolean isFull(int stackId) {
      if (this.sizes[stackId] == this.stackCapacity) {
        return true;
      }
      return false;
    }

    private boolean isEmpty(int stackId) {
      return this.sizes[stackId] == 0;
    }
  }
}
