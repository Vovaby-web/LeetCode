// https://leetcode.com/problems/longest-substring-without-repeating-characters/
import Yandex.L10_Tree.T113_PathSumII;

import java.util.*;
public class Test {
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
        new TreeNode(3)), 3));
  }
  private static List<List<Integer>> result = new ArrayList<>();
  private static List<Integer> temp = new ArrayList<>();
  public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    dfs(root, targetSum);
    return result;
  }
  private static void dfs(TreeNode root, int sum) {
    if (root == null)
      return;
    sum -= root.val;
    temp.add(root.val);
    if (root.left == null && root.right == null && sum == 0)
      result.add(new ArrayList<>(temp));
    dfs(root.left,sum);
    dfs(root.right,sum);
    temp.remove(temp.size()-1);
  }
}
