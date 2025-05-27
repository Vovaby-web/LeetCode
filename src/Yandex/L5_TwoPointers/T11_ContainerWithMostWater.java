package Tasks.LeetCode.Yandex.L5_TwoPointers;
public class T11_ContainerWithMostWater {
  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }
  static {
    for (int i = 0; i < 500; i++)
      maxArea(new int[]{0, 0});
  }
  public static int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int ans = 0;
    while (left < right) {
      int h = Math.min(height[left], height[right]);
      ans = Math.max(ans, h * (right - left));
      while (left < right && height[left] <= h)
        left++;
      while (left < right && height[right] <= h)
        right--;
    }
    return ans;
  }
}
