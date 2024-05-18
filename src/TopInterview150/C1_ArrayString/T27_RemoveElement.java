// https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
import java.util.Arrays;
public class T27_RemoveElement {
  public static void main(String[] args) {
    int[] nums = {3, 2, 2, 3};     // Input array
    int val = 2;                // Value to remove
    int[] expectedNums = {1, 3, 0, 0}; // The expected answer with correct length.
    // It is sorted with no values equaling val.
    int k = removeElement(nums, val); // Calls your implementation
    assert k == expectedNums.length;
    Arrays.sort(nums, 0, k); // Sort the first k elements of nums
    for (int i = 0; i < nums.length; i++) {
      assert nums[i] == expectedNums[i];
    }
  }
  public static int removeElement(int[] nums, int val) {
    int k = 0;
    for (int x : nums) {
      if (x != val) {
        nums[k++] = x;
      }
    }
    return k;
  }
}
