package Tasks.LeetCode.Yandex.L10_Queue_Stack;
import java.util.ArrayDeque;
import java.util.Deque;
public class T150_EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Deque<Integer> dq = new ArrayDeque<>();
    int x2;
    int x1;
    for (String s : tokens) {
      switch (s) {
        case "+":
          x2 = dq.pollLast();
          x1 = dq.pollLast();
          dq.add(x1 + x2);
          break;
        case "-":
          x2 = dq.pollLast();
          x1 = dq.pollLast();
          dq.add(x1 - x2);
          break;
        case "/":
          x2 = dq.pollLast();
          x1 = dq.pollLast();
          dq.add(x1 / x2);
          break;
        case "*":
          x2 = dq.pollLast();
          x1 = dq.pollLast();
          dq.add(x1 * x2);
          break;
        default:
          dq.add(Integer.parseInt(s));
      }
    }
    return dq.pollLast();
  }
}
