package Tasks.LeetCode.Yandex.L5_TwoPointers;
public class T581_ShortestUnsortedContinuousSubarray {
  public static void main(String[] args) {
    System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
  }
  public static int findUnsortedSubarray(int[] nums) {
    int n = nums.length;
    int left = 0;
    int right = 0;
    int min = nums[n - 1];
    int max = nums[0];
    for (int i = 1; i < n; i++) {
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[n - 1 - i]);
      if (nums[i] < max) {
        right = i;
      }
      if (nums[n - 1 - i] > min) {
        left = n - 1 - i;
      }
    }
    if (left == right)
      return 0;
    return right - left + 1;
  }
}
