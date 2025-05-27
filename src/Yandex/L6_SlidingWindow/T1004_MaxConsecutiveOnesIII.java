// https://leetcode.com/problems/max-consecutive-ones-iii/description/
package Tasks.LeetCode.Yandex.L6_SlidingWindow;
public class T1004_MaxConsecutiveOnesIII {
  public static void main(String[] args) {
    System.out.println(longestOnes(new int[]{0, 0, 0, 1}, 4));
  }
  public static int longestOnes(int[] nums, int k) {
    int l = 0;
    int ans = 0;
    for (int r = 0; r < nums.length; r++) {
      if (nums[r] == 0) {
        k--;
      }
      while (k < 0) {
        if (nums[l] == 0)
          k++;
        l++;
      }
      ans = Math.max(ans, r - l + 1);
    }
    return ans;
  }
}
