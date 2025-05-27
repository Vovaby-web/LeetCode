// https://leetcode.com/problems/4sum/
package Tasks.LeetCode.Yandex.L3_HashTable;
import java.util.*;
public class T18_4Sum {
  public static void main(String[] args) {
    int[] nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    List<List<Integer>> result = fourSum(nums, target);
    for (List<Integer> list : result) {
      System.out.println(list);
    }
  }
  // ¬ременна€ сложность Ч O(n^3)
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    int n = nums.length;
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < n - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      for (int j = i + 1; j < n - 2; j++) {
        if (i != j - 1 && nums[j] == nums[j - 1])
          continue;
        int l = j + 1;
        int r = n - 1;
        while (l < r) {
          long x = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];
          if (x < target) {
            l++;
          } else if (x > target) {
            r--;
          } else {
            ans.add(new ArrayList<>(List.of(nums[i], nums[j], nums[l++], nums[r--])));
            while (l <= r && nums[l] == nums[l - 1])
              l++;
            while (l <= r && nums[r] == nums[r + 1])
              r--;
          }
        }
      }
    }
    return ans;
  }
}
