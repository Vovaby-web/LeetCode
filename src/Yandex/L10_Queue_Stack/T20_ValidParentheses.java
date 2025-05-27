package Tasks.LeetCode.Yandex.L10_Queue_Stack;
import java.util.ArrayDeque;
import java.util.Deque;
public class T20_ValidParentheses {
  public boolean isValid(String s) {
    Deque<Character> dq = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[')
        dq.addLast(c);
      else {
        if (dq.isEmpty())
          return false;
        char o = dq.pollLast();
        if ((c == ')' && o != '(') || (c == ']' && o != '[') || (c == '}' && o != '{'))
          return false;
      }
    }
    return dq.isEmpty();
  }
}
