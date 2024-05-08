// https://leetcode.com/problems/path-sum-ii/description/
package Yandex.L10_Tree;
import java.util.*;
public class T113_PathSumII {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
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
    System.out.println(pathSum(
      new TreeNode(1, new TreeNode(2),
        new TreeNode(3)),10));
  }
  private static List<List<Integer>> result = new ArrayList<>();
  private static List<Integer> temp = new ArrayList<>();
  public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    dfs(root, targetSum);
    return result;
  }
  private static void dfs(TreeNode root, int x) {
    if (root == null) {
      return;
    }
    x -= root.val;
    temp.add(root.val);
    if (root.left == null && root.right == null && x == 0) {
      result.add(new ArrayList<>(temp));
    }
    dfs(root.left, x);
    dfs(root.right, x);
    temp.remove(temp.size() - 1);
  }
}
