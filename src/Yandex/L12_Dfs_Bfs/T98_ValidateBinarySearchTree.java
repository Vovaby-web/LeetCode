package Tasks.LeetCode.Yandex.L12_Dfs_Bfs;
import java.util.LinkedList;
import java.util.Queue;
public class T98_ValidateBinarySearchTree {
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

  }
  public static boolean isValidBST(TreeNode root) {
    return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  public static boolean valid(TreeNode root, long min, long max) {
    if (root == null)
      return true;
    if (root.val >= max || root.val <= min)
      return false;
    return valid(root.left, min, Math.min(root.val, max)) &&
       valid(root.right, Math.max(root.val, min), max);
  }
  public boolean isValidBST1(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Long> minQueue = new LinkedList<>();
    Queue<Long> maxQueue = new LinkedList<>();
    queue.offer(root);
    minQueue.offer(Long.MIN_VALUE);
    maxQueue.offer(Long.MAX_VALUE);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      long min = minQueue.poll();
      long max = maxQueue.poll();
      if (node.val <= min || node.val >= max) {
        return false;
      }
      if (node.left != null) {
        queue.offer(node.left);
        minQueue.offer(min);
        maxQueue.offer((long) node.val);
      }
      if (node.right != null) {
        queue.offer(node.right);
        minQueue.offer((long) node.val);
        maxQueue.offer(max);
      }
    }
    return true;
  }
}
