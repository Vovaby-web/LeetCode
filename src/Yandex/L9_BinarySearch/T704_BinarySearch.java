// https://leetcode.com/problems/binary-search/description/
package Tasks.LeetCode.Yandex.L9_BinarySearch;
public class T704_BinarySearch {
  public static void main(String[] args) {
    System.out.println(search(new int[]{1, 5, 6, 9, 10}, 9));
  }
  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] < target)
        left = mid + 1;
      else if (nums[mid] > target)
        right = mid - 1;
      else return mid;
    }
    return -1;
  }
}
