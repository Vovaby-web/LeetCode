// https://leetcode.com/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C10_BinaryTreeBFS;
import java.util.*;
public class T199_BinaryTreeRightSideView {
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
    System.out.println(rightSideView(new TreeNode(1, new TreeNode(2, null,
       new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)))));
  }
  static List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    rview(root, list, 0);
    return list;
  }
  static void rview(TreeNode root, List<Integer> list, int level) {
    if (root == null)
      return;
    if (level == list.size())
      list.add(root.val);
    rview(root.right, list, level + 1);
    rview(root.left, list, level + 1);
  }
  static List<Integer> rightSideView1(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null)
      return list;
    Deque<TreeNode> d = new ArrayDeque<>();
    d.add(root);
    while (!d.isEmpty()) {
      for (int i = d.size(); i > 0; i--) {
        TreeNode cur = d.poll();
        if (i == 1)
          list.add(cur.val);
        if (cur.left != null)
          d.add(cur.left);
        if (cur.right != null)
          d.add(cur.right);
      }
    }
    return list;
  }
}
