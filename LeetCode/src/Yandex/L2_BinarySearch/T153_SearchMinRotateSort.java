// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
package Lessons.LeetCode.Yandex.L2_BinarySearch;
public class T153_SearchMinRotateSort {
  public static void main(String[] args) {
    int[] a = {4, 5, 6, 7, 0, 1, 2, 3};
    System.out.println(findMin(a));
  }
  public static int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int mid;
    int min = nums[left];
    while (left <= right) {
      mid = (left + right) / 2;
      if (nums[mid] < nums[right])
        right = mid - 1;
      else
        left = mid + 1;
      if (min > nums[mid])
        min = nums[mid];
    }
    return min;
  }
}
