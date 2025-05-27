package Tasks.LeetCode.Yandex.L12_Dfs_Bfs;
import java.util.*;
public class T22_GenerateParentheses {
  static class Node {
    String str;
    int left, right;
    public Node(String str, int left, int right) {
      this.str = str;
      this.left = left;
      this.right = right;
    }
  }
  public static void main(String[] args) {
    List<String> result = generateParenthesis(3);
    System.out.println(result);
  }
  // Общее количество возможных комбинаций скобок для заданного n равно числу Каталана
  // Cn = (2n)!/n!(n+1)! (! - факториал)
  // Сложность - O(Cn)
  public static List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node("", 0, 0));
    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      if (curr.left == n && curr.right == n) {
        ans.add(curr.str);
      }
      if (curr.left < n) {
        queue.offer(new Node(curr.str + "(", curr.left + 1, curr.right));
      }
      if (curr.right < curr.left) {
        queue.offer(new Node(curr.str + ")", curr.left, curr.right + 1));
      }
    }
    return ans;
  }
}
