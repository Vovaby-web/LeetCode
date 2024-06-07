// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
public class T104_BinaryTreeGeneral {
  public static class TreeNode {
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
  public static int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    int l = maxDepth(root.left);
    int r = maxDepth(root.right);
    return 1 + Math.max(l, r);
  }
}

