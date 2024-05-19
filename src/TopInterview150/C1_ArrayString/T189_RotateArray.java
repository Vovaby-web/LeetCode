// https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
import java.util.Arrays;
public class T189_RotateArray {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    rotate(nums, k);
    System.out.println(Arrays.toString(nums));
  }
  public static void rotate(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
  }
  public static void reverse(int[] nums, int l, int r) {
    while (l < r) {
      int temp = nums[l];
      nums[l] = nums[r];
      nums[r] = temp;
      l++;
      r--;
    }
  }
}
