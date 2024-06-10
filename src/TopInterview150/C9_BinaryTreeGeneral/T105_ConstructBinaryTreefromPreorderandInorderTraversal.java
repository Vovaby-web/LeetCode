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
    System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
  }
  static int i, p;
  public static TreeNode buildTree(int[] pre, int[] in) {
    i = p = 0;
    return dfs(pre, in, 3001);
  }
  private static TreeNode dfs(int[] pre, int[] in, int right) {
    if (p == pre.length || in[i] == right)
      return null;
    TreeNode node = new TreeNode(pre[p++]);
    node.left = dfs(pre, in, node.val);
    i++;
    node.right = dfs(pre, in, right);
    return node;
  }
}
