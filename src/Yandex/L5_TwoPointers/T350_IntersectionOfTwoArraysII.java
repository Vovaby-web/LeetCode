// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
package Tasks.LeetCode.Yandex.L5_TwoPointers;
import java.util.*;

public class T350_IntersectionOfTwoArraysII {
  public static void main(String[] args) {
    int[] nums1 = {1, 2, 2, 1};
    int[] nums2 = {2, 2};
    int[] result = intersect(nums1, nums2);
    for (int num : result) {
      System.out.print(num + " ");
    }
  }
  public static int[] intersect(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0;
    int j = 0;
    List<Integer> ans = new ArrayList<>();
    while (i < n && j < m) {
      if (nums1[i] == nums2[j]) {
        ans.add(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] < nums2[j])
        i++;
      else j++;
    }
    return ans.stream().mapToInt(a -> a).toArray();
  }
  public static int[] intersect1(int[] nums1, int[] nums2) {
    Map<Integer, Integer> countMap = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    for (int num : nums1) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }
    for (int num : nums2) {
      if (countMap.containsKey(num) && countMap.get(num) > 0) {
        result.add(num);
        countMap.put(num, countMap.get(num) - 1);
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}


