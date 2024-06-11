// https://leetcode.com/problems/path-sum/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
public class T112_PathSum {
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
    System.out.println(hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
       5));
  }
  static boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    int x = targetSum;
    x -= root.val;
    if (root.left == null && root.right == null && x == 0)
      return true;
    return hasPathSum(root.left, x) || hasPathSum(root.right, x);
  }
}
