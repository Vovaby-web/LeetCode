// https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T55_JumpGame {
  public static void main(String[] args) {
    System.out.println(canJump(new int[]{1, 1, 2, 2, 0, 1, 1}));
  }
  public static boolean canJump(int[] nums) {
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (i > max){
        return false;
      }
      max = Math.max(max, i + nums[i]);
    }
    return true;
  }
}

