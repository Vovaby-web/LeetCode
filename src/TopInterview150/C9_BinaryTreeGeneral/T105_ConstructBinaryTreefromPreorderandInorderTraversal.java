// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
import java.util.*;
public class T105_ConstructBinaryTreefromPreorderandInorderTraversal {
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
    @Override
    public String toString() {
      return "TreeNode{" +
         "val=" + val +
         ", left=" + left +
         ", right=" + right +
         '}';
    }
  }
  public static void main(String[] args) {
    System.out.println(buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7}));
  }
  private static int i = 0;
  private static int p = 0;
  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, inorder, Integer.MIN_VALUE);
  }
  private static TreeNode build(int[] preorder, int[] inorder, int stop) {
    if (p >= preorder.length) {
      return null;
    }
    if (inorder[i] == stop) {
      i++;
      return null;
    }
    TreeNode node = new TreeNode(preorder[p++]);
    node.left = build(preorder, inorder, node.val);
    node.right = build(preorder, inorder, stop);
    return node;
  }
}
