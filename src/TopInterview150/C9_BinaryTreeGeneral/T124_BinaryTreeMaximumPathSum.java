// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
public class T124_BinaryTreeMaximumPathSum {
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
    System.out.println(maxPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
  }
  private static int maxSum = -1001;
  public static int maxPathSum(TreeNode root) {
    dfs(root);
    return maxSum;
  }
  private static int dfs(TreeNode head) {
    if (head == null)
      return 0;
    int left = dfs(head.left);
    int right = dfs(head.right);

    int maxSumEndingAtThisNode = Math.max(head.val, (Math.max(left + head.val, right + head.val)));
    int maxSumIncludingThisNode = Math.max(maxSumEndingAtThisNode, head.val + left + right);
    maxSum = Math.max(maxSum, maxSumIncludingThisNode);

    return maxSumEndingAtThisNode;
  }
}
