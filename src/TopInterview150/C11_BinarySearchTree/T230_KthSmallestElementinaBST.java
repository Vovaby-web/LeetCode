// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C11_BinarySearchTree;
import java.util.*;
public class T230_KthSmallestElementinaBST {
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
    System.out.println(kthSmallest(new TreeNode(3, new TreeNode(1,
       null, new TreeNode(2)), new TreeNode(4)), 1));
  }
  static int m;
  static int x = 0;
  static int kthSmallest(TreeNode root, int k) {
    m = k;
    kth(root);
    return x;
  }
  static void kth(TreeNode root) {
    if (root == null || m == 0)
      return;
    kth(root.left);
    if (--m == 0) {
      x = root.val;
      return;
    }
    kth(root.right);
  }
  static int kthSmallest1(TreeNode root, int k) {
    Deque<TreeNode> d = new ArrayDeque<>();
    while (root != null || !d.isEmpty()) {
      if (root != null) {
        d.push(root);
        root = root.left;
      } else {
        root = d.pop();
        if (--k == 0) {
          return root.val;
        }
        root = root.right;
      }
    }
    return 0;
  }
}
