// https://leetcode.com/problems/binary-search/description/
package Yandex.L2_BinarySearch;
public class T704_BinarySearch {
  public static void main(String[] args) {
    int[] a = {-1, 0, 3, 5, 9, 12};
    System.out.println(search(a, 9));
  }
  public static int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    int result = -1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
      if (nums[mid] == target) {
        result = mid;
      }
    }
    return result;
  }
}
