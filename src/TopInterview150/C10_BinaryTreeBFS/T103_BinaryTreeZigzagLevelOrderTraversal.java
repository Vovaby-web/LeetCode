// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C10_BinaryTreeBFS;
import java.util.*;
public class T103_BinaryTreeZigzagLevelOrderTraversal {
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
    System.out.println(zigzagLevelOrder1(new TreeNode(3, new TreeNode(9),
       new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
  }
  static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> l = new ArrayList<>();
    if (root == null)
      return l;
    Deque<TreeNode> d = new ArrayDeque<>();
    d.add(root);
    int s = 1;
    while (!d.isEmpty()) {
      List<Integer> node = new ArrayList<>();
      for (int i = d.size(); i > 0; i--) {
        TreeNode cur = d.poll();
        if (s == 1)
          node.add(cur.val);
        else node.add(0, cur.val);
        if (cur.left != null)
          d.add(cur.left);
        if (cur.right != null)
          d.add(cur.right);
      }
      s = -s;
      l.add(node);
    }
    return l;
  }
  static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
    List<List<Integer>> l = new ArrayList<>();
    zigzag(root, l, 0);
    return l;
  }
  static void zigzag(TreeNode root, List<List<Integer>> l, int lebel) {
    if (root == null)
      return;
    if (l.size() > lebel) {
      if (lebel%2==0)
        l.get(lebel).add(root.val);
      else l.get(lebel).add(0,root.val);
    } else {
      List<Integer> node=new ArrayList<>();
      node.add(root.val);
      l.add(node);
    }
    zigzag(root.left, l, lebel + 1);
    zigzag(root.right, l, lebel + 1);
  }
}
