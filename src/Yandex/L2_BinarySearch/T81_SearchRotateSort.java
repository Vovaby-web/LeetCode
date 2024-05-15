// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
package Lessons.LeetCode.Yandex.L2_BinarySearch;
public class T81_SearchRotateSort {
  public static void main(String[] args) {
    // Данный пример не работает - он исключение
    // int[] a = {1,3,3,4,1,2,3,4};
    int[] a = {0,0,1,1,2,0};
    int target = 2;
    System.out.println(search(a, target));
  }
  public static boolean search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[left] == target || nums[mid] == target || nums[right] == target) {
        return true;
      }
      if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
        left++;
        right--;
        // Если массив с левой части от left до mid не поменялся
      } else if (nums[left] <= nums[mid]) {
        // Если слева, там где массив не поменялся, в наш диапазон попало число target
        // тогда сдвигаем правую границу
        if (target > nums[left] && target < nums[mid])
          right = mid - 1;
        else
          left = left + 1;
      } else {
        // Если массив с правой части от mid до right не поменялся
        // Если справа, там где массив не поменялся, в наш диапазон попало число target
        // тогда сдвигаем левую границу
        if (target > nums[mid] && target < nums[right])
          left = left + 1;
        else
          right = mid - 1;
      }
    }
    return false;
  }
}
