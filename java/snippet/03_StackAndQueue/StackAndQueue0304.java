import java.util.*;

// MyQUeueというクラス名で、2つのスタックを用いてキューを実装してください

public class StackAndQueue0303 {
  public static void main(String[] args) {
  }
}

class MyQueue<T> {
  private Stack<T> stack1;
  private Stack<T> stack2;

  public MyQueue() {
    this.stack1 = new Stack<T>();
    this.stack2 = new Stack<T>();
  }

  public int size() {
    return stack1.size() + stack2.size();
  }

  private void shiftStacks() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
  }

  public T peek() {
    this.shiftStacks();
    return stack2.peek();
  }

  public void add(T val) {
    stack1.push(val);
  }

  public T remove() {
    this.shiftStacks();
    return stack2.pop();
  }
}
