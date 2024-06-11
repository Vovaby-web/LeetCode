// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
public class T106_ConstructBinaryTreefromInorderandPostorderTraversal {
   public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() { }
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
        "val=" + val + ", left=" + left + ", right=" + right + '}';
    }
  }
  public static void main(String[] args) {
    System.out.println(buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
  }
  private static int i, p;
  private static TreeNode buildTree(int[] in, int[] po) {
    i = p = po.length - 1;
    return dfs(in, po, 3001);
  }
  private static TreeNode dfs(int[] in, int[] po, int left) {
    if (p == -1 || in[i] == left)
      return null;
    TreeNode node = new TreeNode(po[p--]);
    node.right = dfs(in, po, node.val);
    i--;
    node.left  = dfs(in, po, left);
    return node;
  }
}
