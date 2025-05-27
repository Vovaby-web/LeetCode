package Tasks.LeetCode.Yandex.L11_Tree;
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
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    System.out.println(maxPathSum(root));
  }
  private static int ans = -1001;
  public static int maxPathSum(TreeNode root) {
    dfs(root);
    return ans;
  }
  private static int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = Math.max(0, dfs(root.left));
    int right = Math.max(0, dfs(root.right));
    ans = Math.max(ans, root.val + left + right);
    return root.val + Math.max(left, right);
  }
}
