// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
public class T129_SumRoottoLeafNumbers {
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
    System.out.println(sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
  }
  static int sumNumbers(TreeNode root) {
    return dfs(root, 0);
  }
  static int dfs(TreeNode r, int x) {
    if (r == null)
      return 0;
    int y = r.val+x*10;
    if (r.left == null && r.right == null)
      return y;
    y = dfs(r.left, y) + dfs(r.right, y);
    return y;
  }
}
