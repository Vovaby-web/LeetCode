// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C7_Stack;
import java.util.ArrayDeque;
import java.util.Deque;
public class T150_EvaluateReversePolishNotation {
  public static void main(String[] args) {
    System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+", "5","+"}));
  }
  public static int evalRPN(String[] tokens) {
    Deque<Integer> stk = new ArrayDeque<>();
    for (String s : tokens) {
      if (s.length() > 1 || Character.isDigit(s.charAt(0))) {
        stk.push(Integer.parseInt(s));
      } else {
        int a = stk.pop();
        int b = stk.pop();
        switch (s) {
          case "+":
            stk.push(b + a);
            break;
          case "-":
            stk.push(b - a);
            break;
          case "*":
            stk.push(b * a);
            break;
          default:
            stk.push(b / a);
            break;
        }
      }
    }
    return stk.pop();
  }
}
