// https://leetcode.com/problems/average-of-levels-in-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C10_BinaryTreeBFS;
import java.util.*;
public class T637_AverageofLevelsinBinaryTree {
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
    System.out.println(averageOfLevels(new TreeNode(3, new TreeNode(9),
       new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
  }
  static List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    List<Integer> count = new ArrayList<>();
    calc(root, result, count, 0);
    return result;
  }
  static void calc(TreeNode node, List<Double> coll, List<Integer> count, int level) {
    if (node == null)
      return;
    if (count.size() > level) {
      int old = count.get(level);
      double newAvg = (coll.get(level) * old + node.val) / (old + 1);
      coll.set(level, newAvg);
      count.set(level, old + 1);
    } else {
      coll.add((double) node.val);
      count.add(1);
    }
    calc(node.left, coll, count, level + 1);
    calc(node.right, coll, count, level + 1);
  }
  static List<Double> averageOfLevels1(TreeNode root) {
    List<Double> l = new ArrayList<>();
    if (root == null)
      return l;
    Deque<TreeNode> d = new ArrayDeque<>();
    d.add(root);
    while (!d.isEmpty()) {
      long x = 0;
      int n = d.size();
      for (int i = d.size(); i > 0; i--) {
        TreeNode cur = d.poll();
        x += cur.val;
        if (cur.left != null)
          d.add(cur.left);
        if (cur.right != null)
          d.add(cur.right);
      }
      l.add((double) x / n);
    }
    return l;
  }
}
