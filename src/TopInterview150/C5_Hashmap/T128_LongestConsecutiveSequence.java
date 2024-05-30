// https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C5_Hashmap;
import java.util.Arrays;
public class T128_LongestConsecutiveSequence {
  public static void main(String[] args) {
    System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
  }
  public static int longestConsecutive(int[] nums) {
    if (nums.length == 0)
      return 0;
    Arrays.sort(nums);
    int count = 1;
    int ans = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        continue;
      }
      if ((nums[i + 1] - nums[i]) == 1) {
        count++;
      } else {
        ans = Math.max(ans, count);
        count = 1;
      }
    }
    return Math.max(ans, count);
  }
}
