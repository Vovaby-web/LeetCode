// https://leetcode.com/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C11_BinarySearchTree;
public class T98_ValidateBinarySearchTree {
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
    System.out.println(isValidBST(new TreeNode(5, new TreeNode(1),
       new TreeNode(4, new TreeNode(3), new TreeNode(6)))));
  }
  public static boolean isValidBST(TreeNode root) {
    return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  public static boolean valid(TreeNode root, long min, long max) {
    if (root == null)
      return true;
    if (root.val >= max || root.val <= min)
      return false;
    return valid(root.left, min, root.val) && valid(root.right, root.val, max);
  }
}
