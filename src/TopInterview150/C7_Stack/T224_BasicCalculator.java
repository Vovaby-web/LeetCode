// https://leetcode.com/problems/basic-calculator/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C7_Stack;
import java.util.*;
public class T224_BasicCalculator {
  public static void main(String[] args) {
    System.out.println(calculate("2+(3-1)"));
  }
  public static int calculate(String s) {
    Deque<Integer> deque = new ArrayDeque<>();
    int sign = 1;
    int ans = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        int j = i;
        int x = 0;
        while (j < n && Character.isDigit(s.charAt(j))) {
          x = x * 10 + s.charAt(j) - '0';
          j++;
        }
        ans += sign * x;
        i = j - 1;
      } else if (c == '+') {
        sign = 1;
      } else if (c == '-') {
        sign = -1;
      } else if (c == '(') {
        deque.push(ans);
        deque.push(sign);
        ans = 0;
        sign = 1;
      } else if (c == ')') {
        ans = deque.pop() * ans + deque.pop();
      }
    }
    return ans;
  }
  public static int calculate1(String s) {
    if(s == null)
      return 0;
    int result = 0;
    int sign = 1;
    int num = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(sign);
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c >= '0' && c <= '9') {
        num = num * 10 + (c - '0');
      } else if(c == '+' || c == '-') {
        result += sign * num;
        sign = stack.peek() * (c == '+' ? 1: -1);
        num = 0;
      } else if(c == '(') {
        stack.push(sign);
      } else if(c == ')') {
        stack.pop();
      }
    }
    result += sign * num;
    return result;
  }
}
