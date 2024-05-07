// https://leetcode.com/problems/same-tree/description/
package Yandex.L10_Tree;
import java.util.*;
public class T100_SameTree {
  public static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
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
    System.out.println(isSameTree(new TreeNode(1, new TreeNode(2),new TreeNode(3)),
      new TreeNode(1, new TreeNode(2),new TreeNode(3))));
  }
  public static boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(p);
    queue.add(q);
    while (!queue.isEmpty()) {
      TreeNode first = queue.poll();
      TreeNode second = queue.poll();
      if (first == null && second == null) {
        continue;
      } else if (first == null || second == null || first.val != second.val) {
        return false;
      }
      queue.add(first.left);
      queue.add(second.left);
      queue.add(first.right);
      queue.add(second.right);
    }
    return true;
  }
}
