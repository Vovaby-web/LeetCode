// https://leetcode.com/problems/combination-sum/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C15_Backtracking;
import java.util.*;
public class T39_CombinationSum {
  public static void main(String[] args) {
    System.out.println(combinationSum(new int[]{2,3,6,7},7));
  }
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), candidates, target, 0);
    return ans;
  }
  private static void dfs(List<List<Integer>> ans, List<Integer> temp,
                          int[] c, int t, int i) {
    if (t == 0) {
      ans.add(new ArrayList<>(temp));
      return;
    }
    if (i == c.length || t < 0)
      return;
    for (int j = i; j < c.length; j++) {
      temp.add(c[j]);
      dfs(ans, temp, c, t - c[j], j);
      temp.remove(temp.size() - 1);
    }
  }
}
