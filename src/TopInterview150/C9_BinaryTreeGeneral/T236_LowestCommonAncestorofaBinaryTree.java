// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
public class T236_LowestCommonAncestorofaBinaryTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
      val = x;
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
    TreeNode node = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2)),
       new TreeNode(1, new TreeNode(0), new TreeNode(8)));
    TreeNode p = new TreeNode(9);
    TreeNode q = node.right;
    System.out.println(lowestCommonAncestor(node, p, q));
  }
  static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q)
      return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null)
      return root;
    if (left == null)
      return right;
    else return left;
  }
}
