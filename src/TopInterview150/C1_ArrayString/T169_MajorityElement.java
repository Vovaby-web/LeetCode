// https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T169_MajorityElement {
  public static void main(String[] args) {
    System.out.println(majorityElement(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
  }
  public static int majorityElement(int[] nums) {
    int n = nums.length;
    int k = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (k == 0) {
        ans = nums[i];
        k = 1;
      } else {
        k += (ans == nums[i]) ? 1 : -1;
      }
    }
    return ans;
  }
}
