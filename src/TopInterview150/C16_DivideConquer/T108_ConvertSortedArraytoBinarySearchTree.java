// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C16_DivideConquer;
public class T108_ConvertSortedArraytoBinarySearchTree {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
      this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  public static void main(String[] args) {
    System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
  }
  static TreeNode sortedArrayToBST(int[] nums) {
    int n = nums.length - 1;
    return bst(nums, 0, n);
  }
  static TreeNode bst(int[] nums, int l, int r) {
    if (l > r)
      return null;
    int mid = (l + r) / 2;
    TreeNode left = bst(nums, l, mid - 1);
    TreeNode right = bst(nums, mid + 1, r);
    return new TreeNode(nums[mid], left, right);
  }
}
