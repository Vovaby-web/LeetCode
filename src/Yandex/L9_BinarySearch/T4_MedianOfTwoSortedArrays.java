// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
package Tasks.LeetCode.Yandex.L9_BinarySearch;
public class T4_MedianOfTwoSortedArrays {
  public static void main(String[] args) {
    System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
  }
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int[] a = new int[n + m];
    int i = 0, j = 0, k = 0;
    if (n == 0 && m == 0)
      return 0;
    while (i < n && j < m) {
      if (nums1[i] < nums2[j])
        a[k++] = nums1[i++];
      else a[k++] = nums2[j++];
    }
    while (i < n) {
      a[k++] = nums1[i++];
    }
    while (j < m) {
      a[k++] = nums2[j++];
    }
    double ans;
    int x = k / 2;
    if (k % 2 == 0) {
      ans = ((double) a[x - 1] + (double) a[x]) / 2.0;
    } else ans = a[x];
    return ans;
  }
}
