// https://leetcode.com/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C6_Intervals;
import java.util.*;
public class T228_SummaryRanges {
  public static void main(String[] args) {
    System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
  }
  public static List<String> summaryRanges(int[] nums) {
    List<String> ans = new ArrayList<>();
    for (int i = 0, j, n = nums.length; i < n; i = j + 1) {
      j = i;
      while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
        j++;
      }
      ans.add(f(nums, i, j));
    }
    return ans;
  }
  private static String f(int[] nums, int i, int j) {
    return i == j ? nums[i] + "" : String.format("%d->%d", nums[i], nums[j]);
  }
}
