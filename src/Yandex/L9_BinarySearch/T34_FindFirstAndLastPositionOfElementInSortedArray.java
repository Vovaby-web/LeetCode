// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
package Tasks.LeetCode.Yandex.L9_BinarySearch;
import java.util.Arrays;
public class T34_FindFirstAndLastPositionOfElementInSortedArray {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
  }
  public static int[] searchRange(int[] nums, int target) {
    int[] ans = {-1, -1};
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (left < nums.length && nums[left] == target)
      ans[0] = left;
    else return ans;
    right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    ans[1] = right;
    return ans;
  }
}
