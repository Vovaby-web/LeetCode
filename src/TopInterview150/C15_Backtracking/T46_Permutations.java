// https://leetcode.com/problems/permutations/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C15_Backtracking;
import java.util.*;
public class T46_Permutations {
  public static void main(String[] args) {
    System.out.println(permute(new int[]{1, 2, 3}));
  }
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(nums, 0, new boolean[nums.length], new ArrayList<>(), ans);
    return ans;
  }
  private static void dfs(int[] nums, int i, boolean[] vis, List<Integer> t,
                          List<List<Integer>> ans) {
    if (i == nums.length) {
      ans.add(new ArrayList<>(t));
      return;
    }
    for (int j = 0; j < nums.length; j++) {
      if (!vis[j]) {
        vis[j] = true;
        t.add(nums[j]);
        dfs(nums, i + 1, vis, t, ans);
        t.remove(t.size() - 1);
        vis[j] = false;
      }
    }
  }
}
