// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
package Lessons.LeetCode.Yandex.L2_BinarySearch;
public class T33_SearchRotateSort {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    int target = 2;
    System.out.println(search(a, target));
  }
  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target)
        return mid;
      // ���� ������ � ����� ����� �� left �� mid �� ���������
      if (nums[left] <= nums[mid]) {
        // ���� �����, ��� ��� ������ �� ���������, � ��� �������� ������ ����� target
        // ����� �������� ������ �������
        if (target >= nums[left] && target < nums[mid])
          right = mid - 1;
        else
          left = mid + 1;
      } else {
        // ���� ������ � ������ ����� �� mid �� right �� ���������
        // ���� ������, ��� ��� ������ �� ���������, � ��� �������� ������ ����� target
        // ����� �������� ����� �������
        if (target > nums[mid] && target <= nums[right])
          left = mid + 1;
        else
          right = mid - 1;
      }
    }
    return -1;
  }
}
