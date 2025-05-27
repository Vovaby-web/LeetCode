package Tasks.LeetCode.Yandex.L11_Tree;
public class T235_LowestCommonAncestorOfBinarySearchTree {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
      val = x;
    }
  }
  public static void main(String[] args) {

  }
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val < Math.min(p.val, q.val))
      return lowestCommonAncestor(root.right, p, q);
    if (root.val > Math.max(p.val, q.val))
      return lowestCommonAncestor(root.left, p, q);
    return root;
  }
}
