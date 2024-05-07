package Yandex.L10_Tree;
import java.util.*;
public class T101_SymmetricTree {
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
  }
  public static void main(String[] args) {
    System.out.println(isSymmetric(
      new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
        new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
  }
  public static boolean isSymmetric(TreeNode root) {
    return dfs(root, root);
  }
  public static boolean dfs(TreeNode root1, TreeNode root2) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root1);
    queue.add(root2);
    while (!queue.isEmpty()) {
      TreeNode left = queue.poll();
      TreeNode right = queue.poll();
      if (left == null && right == null) {
        continue;
      } else if (left == null || right == null || left.val != right.val) {
        return false;
      }
      queue.offer(left.left);
      queue.offer(right.right);
      queue.offer(left.right);
      queue.offer(right.left);
    }
    return true;
  }
}
