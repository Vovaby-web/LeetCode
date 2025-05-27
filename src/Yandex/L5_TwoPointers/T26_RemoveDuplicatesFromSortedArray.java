// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
package Tasks.LeetCode.Yandex.L5_TwoPointers;
public class T26_RemoveDuplicatesFromSortedArray {
  public static void main(String[] args) {
    System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
  }
  public static int removeDuplicates(int[] nums) {
    int n = nums.length;
    int i = 0;
    for (int x : nums) {
      if (i < n - 1 && nums[i] != x) {
        nums[++i] = x;
      }
    }
    return i + 1;
  }
}
