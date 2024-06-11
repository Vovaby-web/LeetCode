// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C9_BinaryTreeGeneral;
import java.util.*;
public class T117_PopulatingNextRightPointersinEachNode2 {
  private static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {
    }
    public Node(int _val) {
      val = _val;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
  public static void main(String[] args) {
    System.out.println(connect(new Node(1,new Node(2,new Node(4),new Node(5),null),
       new Node(3,null,new Node(7),null),null)));
  }
  public static Node connect(Node root) {
    if (root == null) {
      return root;
    }
    Deque<Node> q = new ArrayDeque<>();
    q.offer(root);
    while (!q.isEmpty()) {
      Node p = null;
      // i = первоначальному значению размера нашей очереди и если мы туда добавим
      // элементы, то i меняться не будет
      for (int i = q.size(); i > 0; i--)  {
        Node node = q.poll();
        if (p != null)
          p.next = node;
        p = node;
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
    }
    return root;
  }
}
