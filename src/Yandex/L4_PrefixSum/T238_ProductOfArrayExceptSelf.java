// https://leetcode.com/problems/product-of-array-except-self/
package Tasks.LeetCode.Yandex.L4_PrefixSum;
import java.util.Arrays;
public class T238_ProductOfArrayExceptSelf {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
  }
  public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] prefixLeft = new int[n + 1];
    prefixLeft[0] = 1;
    for (int i = 1; i < n; i++) {
      prefixLeft[i] = prefixLeft[i - 1] * nums[i - 1];
    }
    int previus = 1;
    for (int i = n - 1; i >= 0; i--) {
      int current = nums[i];
      nums[i] = prefixLeft[i] * previus;
      previus = previus * current;
    }
    return nums;
  }
}
