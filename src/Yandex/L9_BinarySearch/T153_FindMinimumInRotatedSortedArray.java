// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
package Tasks.LeetCode.Yandex.L9_BinarySearch;
public class T153_FindMinimumInRotatedSortedArray {
  public static void main(String[] args) {
    System.out.println(findMin(new int[]{2, 1}));
  }
  public static int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int min = nums[0];
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[left] <= nums[mid]) {
        if (min > nums[left])
          min = nums[left];
        left = mid + 1;
      } else {
        if (min > nums[mid])
          min = nums[mid];
        right = mid - 1;
      }
    }
    return min;
  }
}
