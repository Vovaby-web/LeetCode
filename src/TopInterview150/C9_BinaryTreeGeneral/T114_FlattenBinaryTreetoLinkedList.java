// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
public class T114_FlattenBinaryTreetoLinkedList {
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
    flatten(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
       new TreeNode(5, null, new TreeNode(6))));
  }
  public static void flatten(TreeNode root) {
    while (root != null) {
      if (root.left != null) {
        TreeNode pre = root.left;
        while (pre.right != null) {
          pre = pre.right;
        }
        pre.right = root.right;
        root.right = root.left;
        root.left = null;
      }
      root = root.right;
    }
  }
}
