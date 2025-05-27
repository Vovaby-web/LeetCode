package Tasks.LeetCode.Yandex.L11_Tree;

public class T1261_FindElementsBinaryTree {
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
  static class FindElements {
    TreeNode root;
    public FindElements(TreeNode root) {
      this.root = root;
      dfs(root, 0);
    }
    public boolean find(int target) {
      TreeNode cur = root;
      while (cur != null) {
        if (cur.val == target)
          return true;
        else if (cur.val > target)
          cur = cur.left;
        else cur = cur.right;
      }
      return false;
    }
    private void dfs(TreeNode node, int x) {
      if (node == null)
        return;
      node.val = x;
      if (node.left != null)
        dfs(node.left, 2 * x + 1);
      if (node.right != null)
        dfs(node.right, 2 * x + 2);
    }
  }
   public static void main(String[] args) {
    TreeNode root = new TreeNode(-1);
    root.right = new TreeNode(-1);
    FindElements find=new FindElements(root);
    System.out.println(find.find(1));
    System.out.println(find.find(2));
  }
}
