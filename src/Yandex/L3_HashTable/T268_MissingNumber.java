// https://leetcode.com/problems/missing-number/
package Tasks.LeetCode.Yandex.L3_HashTable;
public class T268_MissingNumber {
  public static void main(String[] args) {
    System.out.println(missingNumber(new int[]{3, 0, 1}));
  }
  public static int missingNumber(int[] nums) {
    int n = nums.length;
    int[] a = new int[n + 1];
    for (int num : nums) {
      a[num]++;
    }
    for (int i = 0; i <= n; i++)
      if (--a[i] < 0)
        return i;
    return 0;
  }
}
