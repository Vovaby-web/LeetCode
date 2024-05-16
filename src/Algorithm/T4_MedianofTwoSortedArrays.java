// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
package Algorithm;
public class T4_MedianofTwoSortedArrays {
  public static void main(String[] args) {
    System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
  }
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int[] a = new int[m + n];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < m && j < n) {
      if (nums1[i] <= nums2[j]) {
        a[k++] = nums1[i++];
      } else {
        a[k++] = nums2[j++];
      }
    }
    while (i < m) {
      a[k++] = nums1[i++];
    }
    while (j < n) {
      a[k++] = nums2[j++];
    }
    int mid = (n + m) / 2;
    return a.length % 2 == 1 ? a[mid] : (double) (a[mid] + a[mid - 1]) / 2.0;
  }
}
