// https://leetcode.com/problems/intersection-of-two-arrays/description/
package Tasks.LeetCode.Yandex.L5_TwoPointers;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class T349_IntersectionOfTwoArrays {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
  }
  public static int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> reserve = new HashSet<>();
    Set<Integer> ans = new HashSet<>();
    for (int x:nums1)
      reserve.add(x);
    for (int x:nums2){
      if (reserve.contains(x))
        ans.add(x);
    }
    return ans.stream().mapToInt(a -> a).toArray();
  }
}
