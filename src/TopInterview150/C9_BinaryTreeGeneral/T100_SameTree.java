// https://leetcode.com/problems/same-tree/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
public class T100_SameTree {
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
    System.out.println(isSameTree1(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
      new TreeNode(1, new TreeNode(2), new TreeNode(3))));
  }
  public static boolean isSameTree1(TreeNode p, TreeNode q) {
    if (p == null && q == null)
      return true;
    if (p == null || q == null || p.val != q.val)
      return false;
    return isSameTree1(p.left,q.left)&&isSameTree1(p.right,q.right);
  }
}


