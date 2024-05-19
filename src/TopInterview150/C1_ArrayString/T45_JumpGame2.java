// https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T45_JumpGame2 {
  public static void main(String[] args) {
    System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
  }
  public static int jump(int[] nums) {
    int n = nums.length;
    int max = 0;
    int last = 0;
    int ans = 0;
    for (int i = 0; i < n - 1; i++) {
      max = Math.max(max, i + nums[i]);
      if (last == i) {
        ans++;
        last = max;
      }
    }
    return ans;
  }
}
