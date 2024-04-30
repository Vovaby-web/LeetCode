package Yandex;
import java.util.*;
public class Test {
 public static void main(String[] args) {
  System.out.println(removeInvalidParentheses("()"));
 }
 public static List<String> removeInvalidParentheses(String s) {
  List<String> res = new ArrayList<>();
  Set<String> visited = new HashSet<>();
  Queue<String> queue = new LinkedList<>();
  queue.offer(s);
  visited.add(s);
  boolean found = false;
  while (!queue.isEmpty()) {
   String current = queue.poll();
   if (isValid(current)) {
    res.add(current);
    found = true;
   }
   if (found) continue;
   for (int i = 0; i < current.length(); i++) {
    if (current.charAt(i) != '(' && current.charAt(i) != ')') continue;
    String next = current.substring(0, i) + current.substring(i + 1);
    if (!visited.contains(next)) {
     queue.offer(next);
     visited.add(next);
    }
   }
  }
  if (res.isEmpty()) {
   res.add("");
  }
  return res;
 }
 private static boolean isValid(String s) {
  Stack<Character> stack = new Stack<>();
  for (char c : s.toCharArray()) {
   if (c == '(') {
    stack.push(c);
   } else if (c == ')') {
    if (!stack.isEmpty() && stack.peek() == '(') {
     stack.pop();
    } else {
     return false;
    }
   }
  }
  return stack.isEmpty();
 }
}