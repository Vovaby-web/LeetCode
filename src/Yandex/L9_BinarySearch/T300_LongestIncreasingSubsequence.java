// https://leetcode.com/problems/longest-increasing-subsequence/description/
package Tasks.LeetCode.Yandex.L9_BinarySearch;
import java.util.ArrayList;
import java.util.List;
public class T300_LongestIncreasingSubsequence {
  public static void main(String[] args) {
    System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
  }
  public static int lengthOfLIS(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    for (int x : nums) {
      int n = ans.size() - 1;
      if (ans.isEmpty() || x > ans.get(n)) {
        ans.add(x);
      } else {
        int left = 0;
        int right = n;
        while (left < right) {
          int mid = (left + right) / 2;
          if (x > ans.get(mid)) {
            left = mid + 1;
          } else {
            right = mid;
          }
        }
        ans.set(right, x);
      }
    }
    return ans.size();
  }
}
