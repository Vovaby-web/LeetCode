package Tasks.LeetCode.Yandex.L10_Queue_Stack;
import java.util.Stack;

public class T716_MaxStack {
  public class MaxStack {
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;
    public MaxStack() {
      stack = new Stack<>();
      maxStack = new Stack<>();
    }
    public void push(int x) {
      stack.push(x);
      if (maxStack.isEmpty() || x >= maxStack.peek()) {
        maxStack.push(x);
      }
    }
    public int pop() {
      int val = stack.pop();
      if (val == maxStack.peek()) {
        maxStack.pop();
      }
      return val;
    }
    public int top() {
      return stack.peek();
    }

    public int peekMax() {
      return maxStack.peek();
    }
    public int popMax() {
      int max = maxStack.pop();
      Stack<Integer> buffer = new Stack<>();
      while (stack.peek() != max) {
        buffer.push(stack.pop());
      }
      stack.pop();
      while (!buffer.isEmpty()) {
        push(buffer.pop());
      }
      return max;
    }
  }

  public static void main(String[] args) {
    T716_MaxStack o = new T716_MaxStack();
    MaxStack maxStack = o.new MaxStack();
    maxStack.push(5);
    maxStack.push(1);
    maxStack.push(5);
    System.out.println(maxStack.top());      // Возвращает 5
    System.out.println(maxStack.popMax());   // Возвращает 5
    System.out.println(maxStack.top());      // Возвращает 1
    System.out.println(maxStack.peekMax());  // Возвращает 5
    System.out.println(maxStack.pop());      // Возвращает 1
    System.out.println(maxStack.top());      // Возвращает 5
  }
}
