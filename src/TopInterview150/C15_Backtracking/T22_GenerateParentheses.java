package TopInterview150.C15_Backtracking;
import java.util.*;
public class T22_GenerateParentheses {
  public static void main(String[] args) {
    System.out.println(generateParenthesis(3));
  }
  public static List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    dfs(ans, new String(),  n, 0, 0 );
    return ans;
  }
  public static void dfs(List<String> ans, String t, int n, int l, int r) {
    if (l == n && r == n)
      ans.add(t);
    if (l < n)
      dfs(ans, t + '(', n, l + 1, r);
    if (l > r)
      dfs(ans, t + ')', n, l, r + 1);
  }
}
