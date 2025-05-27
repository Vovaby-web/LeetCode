// https://leetcode.com/problems/intervals-between-identical-elements/description/
package Tasks.LeetCode.Yandex.L4_PrefixSum;
import java.util.*;
public class T2121_IntervalsBetweenIdenticalElements {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(getDistances(new int[]{1, 1, 1, 1})));
  }
  public static long[] getDistances(int[] arr) {
    int n = arr.length;
    long[] ans = new long[n];
    Map<Integer, Long> sum = new HashMap<>();
    Map<Integer, Integer> count = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (!sum.containsKey(arr[i])) {
        sum.put(arr[i], 0L);
        count.put(arr[i], 0);
      }
      ans[i] = i * (long) count.get(arr[i]) - sum.get(arr[i]);
      sum.put(arr[i], sum.get(arr[i]) + i);
      count.put(arr[i], count.get(arr[i]) + 1);
    }
    sum.clear();
    count.clear();
    for (int i = n - 1; i >= 0; i--) {
      if (!sum.containsKey(arr[i])) {
        sum.put(arr[i], 0L);
        count.put(arr[i], 0);
      }
      ans[i] += (n - i - 1) * (long) count.get(arr[i]) - sum.get(arr[i]);
      sum.put(arr[i], sum.get(arr[i]) + (n - i - 1));
      count.put(arr[i], count.get(arr[i]) + 1);
    }
    return ans;
  }
}
