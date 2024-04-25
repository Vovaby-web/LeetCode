// https://leetcode.com/problems/valid-parentheses/description/
package Lessons.LeetCode.Yandex.L4_Queue_Stack;

import java.util.*;
public class T20_QueueStack {
  public static void main(String[] args) {
    System.out.println(isValid("()"));
  }
  public static boolean isValid(String s) {
    Deque<Character> deque = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        deque.push(c);
      } else if (deque.isEmpty() || !exam(deque.pop(), c)) {
        return false;
      }
    }
    return deque.isEmpty();
  }
  private static boolean exam(char l, char r) {
    return (l == '(' && r == ')') || (l == '{' && r == '}') || (l == '[' && r == ']');
  }
}
