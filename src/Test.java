// https://leetcode.com/contest/weekly-contest-397/problems/taking-maximum-energy-from-the-mystic-dungeon/description/
import java.util.*;
public class Test {
  public static void main(String[] args) {
    merge(new int[]{1,2,3,0,0,0}, 3, new int[]{1,2,3}, 3);
  }
  public static int maximumEnergy(int[] energy, int k) {
    int n = energy.length;
    int max = Integer.MIN_VALUE;
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = energy[i];
      int j = i + k;
      while (j >= 0 && j < n && j != i) {
        if (dp[j] != 0) {
          dp[i] += dp[j];
          break;
        } else
          dp[i] += energy[j];
        j += k;
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if (nums2.length == 0)
      return;
    for (int i = m; i < m + n; i++)
      nums1[i] = nums2[i-m];
    Arrays.sort(nums1);
  }
}
