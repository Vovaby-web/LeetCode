// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T80_RemoveDupSortArray2 {
  public static void main(String[] args) {
    System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
  }
  public static int removeDuplicates(int[] nums) {
    int n = nums.length;
    int k = 0;
    for (int i = 1; i < n; i++) {
      if (i > 1) {
        if (nums[k - 1] != nums[i])
          nums[++k] = nums[i];
      } else k++;
    }
    return k + 1;
  }
}
