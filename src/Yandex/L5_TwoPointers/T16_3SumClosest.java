package Tasks.LeetCode.Yandex.L5_TwoPointers;

import java.util.Arrays;
public class T16_3SumClosest {
  public static void main(String[] args) {
    System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
  }
  public static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    int ans = -1001;
    for (int i = 0; i < n - 2; i++) {
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int x = nums[i] + nums[j] + nums[k];
        if (ans == -1001)
          ans = x;
        else if (Math.abs(x - target) < Math.abs(ans - target))
          ans = x;
        if (x > target)
          k--;
        else if (x < target)
          j++;
        else {
          j++;
          k--;
        }
      }
    }
    return ans;
  }
}
