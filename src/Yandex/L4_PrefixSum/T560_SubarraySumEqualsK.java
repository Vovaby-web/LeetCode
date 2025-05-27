// https://leetcode.com/problems/subarray-sum-equals-k/description/
package Tasks.LeetCode.Yandex.L4_PrefixSum;
import java.util.*;
public class T560_SubarraySumEqualsK {
  public static void main(String[] args) {
    System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));
  }
  public static int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> prefixSumCount = new HashMap<>();
    prefixSumCount.put(0, 1);
    int sum = 0;
    int count = 0;
    for (int num : nums) {
      sum += num;
      int diff = sum - k;
      if (prefixSumCount.containsKey(diff))
        count += prefixSumCount.get(diff);
      prefixSumCount.compute(sum, (a, b) -> (b == null) ? 1 : ++b);
    }
    return count;
  }

}
