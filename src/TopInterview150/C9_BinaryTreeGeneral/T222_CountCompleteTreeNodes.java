// https://leetcode.com/problems/count-complete-tree-nodes/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
public class T222_CountCompleteTreeNodes {
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
    System.out.println(countNodes(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
  }
  static int countNodes(TreeNode root) {
    if (root == null)
      return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
  }
}
