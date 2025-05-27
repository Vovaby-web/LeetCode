// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
package Tasks.LeetCode.Yandex.L9_BinarySearch;
public class T81_SearchInRotatedSortedArrayII {
  public static void main(String[] args) {
    System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
  }
  public static boolean search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[left] == target || nums[right] == target || nums[mid] == target)
        return true;
      if (nums[left] == nums[mid])
        left++;
      else if (nums[left] < nums[mid]) {
        if (nums[left] < target && nums[mid] > target)
          right = mid - 1;
        else left = mid + 1;
      } else {
        if (nums[left] > target && nums[mid] < target)
          left = mid + 1;
        else right = mid - 1;
      }
    }
    return false;
  }
}
