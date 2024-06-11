// https://leetcode.com/problems/binary-search-tree-iterator/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
import java.util.*;
public class T173_BinarySearchTreeIterator {
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
  class BSTIterator {
    private int cur = 0;
    private List<Integer> vals = new ArrayList<>();
    public BSTIterator(TreeNode root) {
      inorder(root);
    }
    public int next() {
      return vals.get(cur++);
    }
    public boolean hasNext() {
      return cur < vals.size();
    }
    private void inorder(TreeNode root) {
      if (root != null) {
        inorder(root.left);
        vals.add(root.val);
        inorder(root.right);
      }
    }
  }
}
