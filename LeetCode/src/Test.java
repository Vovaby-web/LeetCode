// https://leetcode.com/problems/longest-substring-without-repeating-characters/
import java.util.*;
public class Test {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6}, 5)));
  }
  public static int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    if (k==1)
      return Arrays.stream(nums).toArray();
    int l=0;
    int max=0;
    for (int i = 0; i < n; i++) {
      if (i >= k) {
       l++;
      }
      max=Math.max(max,nums[i]);
      if (i >= k - 1) {

      }
    }
    return result;
  }
}
