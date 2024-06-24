// https://leetcode.com/problems/combinations/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C15_Backtracking;
import java.util.*;
public class T77_Combinations {
  public static void main(String[] args) {
    System.out.println(combine(4, 2));
  }
  public static List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(n, k, 1, new ArrayList<>(), ans);
    return ans;
  }
  private static void dfs(int n, int k, int s,
                          List<Integer> path, List<List<Integer>> ans) {
    if (path.size() == k) {
      ans.add(new ArrayList<>(path));
      return;
    }
    for (int i = s; i <= n; i++) {
      path.add(i);
      dfs(n, k, i + 1, path, ans);
      path.remove(path.size() - 1);
    }
  }
}