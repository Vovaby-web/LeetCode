package Tasks.LeetCode.Yandex.L6_SlidingWindow;
public class T487_MaxConsecutiveOnesII {
  public static void main(String[] args) {
    System.out.println(maxConsecutiveOnes(new int[]{1, 0, 1, 1, 0})); // 4
    System.out.println(maxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1})); // 6
    System.out.println(maxConsecutiveOnes(new int[]{0, 0, 0, 0})); // 1
  }
  public static int maxConsecutiveOnes(int[] nums) {
    int n = nums.length;
    if (n == 0)
      return 0;
    int left = 0;
    int ans = 1;
    int k = 0;
    for (int right = 0; right < n; right++) {
      if (nums[right] == 0)
        k++;
      while (k>1) {
        if (nums[left++] == 0)
          k--;
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }
}
