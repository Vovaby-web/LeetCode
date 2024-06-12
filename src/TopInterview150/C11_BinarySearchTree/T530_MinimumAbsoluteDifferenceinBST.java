// https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C11_BinarySearchTree;
public class T530_MinimumAbsoluteDifferenceinBST {
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
    System.out.println(getMinimumDifference(new TreeNode(4, new TreeNode(2,
       new TreeNode(5),new TreeNode(1)), new TreeNode(6))));
  }
  static int min = 1000000;
  static int pre = 1000000;
  static int getMinimumDifference(TreeNode root) {
    if (root == null)
      return 0;
    getMinimumDifference(root.left);
    min = Math.min(min, Math.abs(root.val-pre));
    pre = root.val;
    getMinimumDifference(root.right);
    return min;
  }
}
