// https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C3_SlidingWindow;
public class T209_MinimumSizeSubarraySum {
  public static void main(String[] args) {
    System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
  }
  public static int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int left = 0;
    int right = 0;
    int ans = n + 1;
    int sum = 0;
    while (right < n) {
      sum += nums[right++];
      while (sum >= target) {
        ans = Math.min(ans, right - left);
        sum -= nums[left++];
      }
    }
    if (ans == n + 1) {
      return 0;
    }
    return ans;
  }
}
