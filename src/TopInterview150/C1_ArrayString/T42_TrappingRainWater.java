// https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T42_TrappingRainWater {
  public static void main(String[] args) {
    System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }
  public static int trap(int[] height) {
    int n = height.length;
    int m = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (height[m] < height[i]) {
        m = i;
      }
    }
    int max = 0;
    for (int i = 0; i <= m; i++) {
      if (max > height[i]) {
        ans += max - height[i];
      } else max = height[i];
    }
    max = 0;
    for (int i = n-1; i >= m; i--) {
      if (max > height[i]) {
        ans += max - height[i];
      } else max = height[i];
    }
    return ans;
  }
}
