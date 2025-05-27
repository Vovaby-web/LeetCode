package Tasks.LeetCode.Yandex.L11_Tree;
import java.util.*;
public class T449_SerializeAndDeserializeBST {
  public static void main(String[] args) {
    Codec codec = new Codec();
    Codec.TreeNode root = new Codec.TreeNode(5);
    root.left = new Codec.TreeNode(3);
    root.left.left = new Codec.TreeNode(1);
    root.left.right = new Codec.TreeNode(4);
    root.right = new Codec.TreeNode(8);
    root.right.left = new Codec.TreeNode(7);
    root.right.right = new Codec.TreeNode(9);
    String s = codec.serialize(root);
    System.out.println(s);
    Codec.TreeNode node = codec.deserialize(s);
    System.out.println(codec.serialize(node));
  }
  public static class Codec {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
        val = x;
      }
    }
    private List<String> ans;
    public String serialize(TreeNode root) {
      ans = new LinkedList<>();
      if (root == null)
        return null;
      dfs(root);
      return String.join(",", ans);
    }
    private void dfs(TreeNode node) {
      if (node == null) {
        return;
      }
      dfs(node.right);
      dfs(node.left);
      ans.addFirst(String.valueOf(node.val));
    }
    private List<String> nums;
    int i;
    public TreeNode deserialize(String data) {
      if (data == null || data.isEmpty()) {
        return null;
      }
      i = 0;
      nums = List.of(data.split(","));
      return dfs(-1, 10001);
    }
    private TreeNode dfs(int min, int max) {
      if (i == nums.size()) {
        return null;
      }
      int x = Integer.parseInt(nums.get(i));
      if (x < min || x > max) {
        return null;
      }
      TreeNode root = new TreeNode(x);
      i++;
      root.left = dfs(min, x);
      root.right = dfs(x, max);
      return root;
    }
  }
}
