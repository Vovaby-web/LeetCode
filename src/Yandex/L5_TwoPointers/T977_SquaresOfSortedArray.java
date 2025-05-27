// https://leetcode.com/problems/squares-of-a-sorted-array/description/
package Tasks.LeetCode.Yandex.L5_TwoPointers;
import java.util.Arrays;
public class T977_SquaresOfSortedArray {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
  }
  public static int[] sortedSquares(int[] nums) {
    int m = 0;
    for (int x : nums) {
      if (x < 0)
        m++;
      else break;
    }
    int i = m;
    int j = m - 1;
    int n = nums.length;
    int[] a = new int[n];
    int k = 0;
    while (i < n && j >= 0) {
      if (nums[i] * nums[i] < nums[j] * nums[j])
        a[k++] = nums[i] * nums[i++];
      else a[k++] = nums[j] * nums[j--];
    }
    while (i < n) {
      a[k++] = nums[i] * nums[i++];
    }
    while (j >= 0) {
      a[k++] = nums[j] * nums[j--];
    }
    return a;
  }
}
