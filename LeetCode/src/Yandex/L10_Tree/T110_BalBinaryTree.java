// https://leetcode.com/problems/balanced-binary-tree/description/
package Yandex.L10_Tree;
import java.util.*;
public class T110_BalBinaryTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
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
    System.out.println(isBalanced(
      new TreeNode(1, new TreeNode(2),
        new TreeNode(2, new TreeNode(3), new TreeNode(4)))));
  }
  public static boolean isBalanced(TreeNode root) {
    return height(root) >= 0;
  }
  private static int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = height(root.left);
    int right = height(root.right);
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return -1;
    }
    return 1 + Math.max(left, right);
  }
}
