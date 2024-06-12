// https://leetcode.com/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C10_BinaryTreeBFS;
import java.util.*;
public class T102_BinaryTreeLevelOrderTraversal {
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
    System.out.println(levelOrder1(new TreeNode(3, new TreeNode(9),
       new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
  }
  static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> l = new ArrayList<>();
    if (root == null)
      return l;
    Deque<TreeNode> d = new ArrayDeque<>();
    d.add(root);
    while (!d.isEmpty()) {
      List<Integer> node = new ArrayList<>();
      for (int i = d.size(); i > 0; i--) {
        TreeNode cur = d.poll();
        node.add(cur.val);

        if (cur.left != null)
          d.add(cur.left);
        if (cur.right != null)
          d.add(cur.right);
      }
      l.add(node);
    }
    return l;
  }
  static List<List<Integer>> levelOrder1(TreeNode root) {
    List<List<Integer>> l = new ArrayList<>();
    level(root, l, 0);
    return l;
  }
  static void level(TreeNode root, List<List<Integer>> l, int level) {
    if (root == null)
      return;
    if (l.size() > level) {
      l.get(level).add(root.val);
    } else {
      List<Integer> node = new ArrayList<>();
      node.add(root.val);
      l.add(node);
    }
    level(root.left, l, level + 1);
    level(root.right, l, level + 1);
  }
}
