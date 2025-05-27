// https://leetcode.com/problems/continuous-subarray-sum/description/
package Tasks.LeetCode.Yandex.L4_PrefixSum;
import java.util.HashMap;
import java.util.Map;
public class T523_ContinuousSubarraySum {
  public static void main(String[] args) {
    System.out.println(checkSubarraySum(new int[]{6,2,4,6,7}, 6));
  }
  public static boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int prefixSum = 0;
    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];
      int rem = prefixSum % k;
      if (map.containsKey(rem)) {
        if (i - map.get(rem) > 1) {
          return true;
        }
      } else {
        map.put(rem, i);
      }
    }
    return false;
  }

}
