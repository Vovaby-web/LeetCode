// https://leetcode.com/problems/remove-invalid-parentheses/description/
package Yandex.L5_dfs_bfs;
import java.util.*;
public class T301_RemoveInvalidPar {
 public static void main(String[] args) {
  System.out.println(removeInvalidParentheses(")("));
 }
 public static List<String> removeInvalidParentheses(String s) {
  // Наш результат
  List<String> res = new ArrayList<>();
  // Список строк, которые мы перебрали
  Set<String> visited = new HashSet<>();
  // Наша очередь
  Queue<String> queue = new LinkedList<>();
  // Заносим в очередь всю строку
  queue.offer(s);
  // Заносим в список посещений, но это, чтобы не крутится на месте
  visited.add(s);
  // Если строка соответствует, то found=true;
  boolean found = false;
  // Пока очередь не пуста
  while (!queue.isEmpty()) {
   String current = queue.poll();
   if (isValid(current)) {
    res.add(current);
    found = true;
   }
   if (found) continue;
   for (int i = 0; i < current.length(); i++) {
    // Если наш символ не скобка, а буква
    if (current.charAt(i) != '(' && current.charAt(i) != ')')
     continue;
    // Помещаем в next все, кроме этого символа.
    String next = current.substring(0, i) + current.substring(i + 1);
    // Если не было такой строчки, то помещаем в очередь
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