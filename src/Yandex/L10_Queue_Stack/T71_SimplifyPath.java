package Tasks.LeetCode.Yandex.L10_Queue_Stack;
import java.util.ArrayDeque;
import java.util.Deque;
public class T71_SimplifyPath {
  public static void main(String[] args) {

  }
  public String simplifyPath(String path) {
    String[] str = path.split("/");
    Deque<String> dq = new ArrayDeque<>();
    for (String s : str) {
      if (s.isEmpty())
        continue;
      if (s.equals("..")) {
        if (!dq.isEmpty())
          dq.pollLast();
      } else if (!s.equals("."))
        dq.add(s);
    }
    StringBuilder ans = new StringBuilder();
    while (!dq.isEmpty()) {
      ans.append("/" + dq.poll());
    }
    if (ans.isEmpty())
      return "/";
    else
      return ans.toString();
  }
}
