// https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C7_Stack;
import java.util.ArrayDeque;
import java.util.Deque;
public class T71_SimplifyPath {
  public static void main(String[] args) {
    System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
  }
  public static String simplifyPath(String path) {
    Deque<String> stk = new ArrayDeque<>();
    for (String s : path.split("/")) {
      if ("".equals(s) || ".".equals(s)) {
        continue;
      }
      if ("..".equals(s)) {
        stk.pollLast();
      } else {
        stk.offerLast(s);
      }
    }
    return "/" + String.join("/", stk);
  }
}
