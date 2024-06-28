// https://leetcode.com/problems/4sum/
package Lessons.LeetCode.Yandex.L3_HashTable;
import java.util.*;
public class T18_4Sum {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
    int target = 14;
    List<List<Integer>> result = fourSum(nums, target);
    for (List<Integer> list : result) {
      System.out.println(list);
    }
  }
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    int n = nums.length;
    List<List<Integer>> result = new ArrayList<>();
    if (n < 4) {
      return result;
    }
    Arrays.sort(nums);
    for (int i = 0; i < n - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      for (int j = i + 1; j < n - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1])
          continue;
        int left = j + 1;
        int right = n - 1;
        while (left < right) {
          long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
          if (sum < target) {
            left++;
          } else if (sum > target) {
            right--;
          } else {
            result.add(List.of(nums[i], nums[j], nums[left++], nums[right--]));
            while (left < right && nums[left] == nums[left - 1])
              left++;
            while (left < right && nums[right] == nums[right + 1])
              right--;

          }
        }
      }
    }
    return result;
  }
}
