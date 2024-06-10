import java.util.*;
public class Test {
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
    @Override
    public String toString() {
      return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
    }
  }
  public static void main(String[] args) {
    System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
  }
  static int i=0;
  static int p=0;
  public static TreeNode buildTree(int[] preorder, int[] inorder) {
   return build(preorder,inorder,-1);
  }
  private static TreeNode build(int[] preorder, int[] inorder, int s) {
   if (p>= preorder.length)
     return null;
   if (inorder[i]==s){
     i++;
     return null;
   }
   TreeNode tree=new TreeNode(preorder[p++]);
   tree.left=build(preorder,inorder, tree.val);
   tree.right=build(preorder,inorder, s);
   return tree;
  }
}
