// https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
import java.util.Arrays;
public class T238_ProductofArrayExceptSelf {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(productExceptSelf(new int[]{5,4,6,7})));
  }
  public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    int[] ans1 = new int[n];
    for (int i = 0, left = 1; i < n; i++) {
      ans[i] = left;
      left *= nums[i];
    }
    for (int i = n - 1, right = 1; i >= 0; i--) {
      ans1[i] = right;
      right *= nums[i];
    }
    return ans;
  }
}
