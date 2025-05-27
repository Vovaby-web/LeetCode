package Tasks.LeetCode.Yandex.L12_Dfs_Bfs;
import java.util.*;
public class T301_RemoveInvalidParentheses {
  public static void main(String[] args) {
    System.out.println(removeInvalidParentheses("()())()"));
  }
  private static final Set<String> ans = new HashSet<>();
  public static List<String> removeInvalidParentheses(String s) {
    int l = 0, r = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        l++;
      } else if (c == ')') {
        if (l > 0) {
          l--;
        } else {
          r++;
        }
      }
    }
    dfs(s, 0, l, r, 0, 0, "", s.length());
    return new ArrayList<>(ans);
  }
  private static void dfs(String s, int i, int l, int r, int lCnt, int rCnt, String t, int n) {
    if (i == n) {
      if (l == 0 && r == 0) {
        ans.add(t);
      }
      return;
    }
    if (lCnt < rCnt) {
      return;
    }
    char c = s.charAt(i);
    if (c == '(' && l > 0) {
      dfs(s, i + 1, l - 1, r, lCnt, rCnt, t, n);
    }
    if (c == ')' && r > 0) {
      dfs(s, i + 1, l, r - 1, lCnt, rCnt, t, n);
    }
    int x = c == '(' ? 1 : 0;
    int y = c == ')' ? 1 : 0;
    dfs(s, i + 1, l, r, lCnt + x, rCnt + y, t + c, n);
  }
}

