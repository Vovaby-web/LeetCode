// https://leetcode.com/problems/move-zeroes/description/
package Tasks.LeetCode.Yandex.L5_TwoPointers;
import java.util.Arrays;
public class T283_MoveZeroes {
  public static void main(String[] args) {
    int[] a = {0, 1, 0, 3, 12};
    moveZeroes(a);
    System.out.println(Arrays.toString(a));
  }
  public static void moveZeroes(int[] nums) {
    int n = nums.length;
    int l = 0;
    for (int r = 0; r < n; r++) {
      if (nums[r] != 0) {
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l++] = temp;
      }
    }
  }
}
