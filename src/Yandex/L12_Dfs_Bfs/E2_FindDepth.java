/*
 Есть двоичное дерево
  class TNode {
    int val;
    TNode left;
    TNode right;
    TNode prev;
  }
  Есть функция int find(TNode root, int depth, int other)
  Вывести число, которое находится на глубине depth и имеет номер на глубине depth other при подсчете слева
      3
    2    5
  1  4  6  8
  depth = 2, other = 2
  Ответ = 6
*/
package Tasks.LeetCode.Yandex.L12_Dfs_Bfs;

import java.util.LinkedList;
import java.util.Queue;
public class E2_FindDepth {
  static class TNode {
    int val;
    TNode left;
    TNode right;
    TNode prev;
    public TNode(int val) {
      this.val = val;
    }
    public TNode(int val, TNode left, TNode right, TNode prev) {
      this.val = val;
      this.left = left;
      this.right = right;
      this.prev = prev;
    }
  }
  public static void main(String[] args) {
    TNode root = new TNode(3, new TNode(2), new TNode(5), null);
    root.left.prev = root;
    root.right.prev = root;
    root.left.left = new TNode(1);
    root.left.left.prev = root.left;
    root.left.right = new TNode(4);
    root.left.right.prev = root.left;
    root.right.left = new TNode(6);
    root.right.left.prev = root.right;
    root.right.right = new TNode(8);
    root.right.right.prev = root.right;
    int depth = 2;
    int other = 1;
    System.out.println(find1(root, depth, other));
  }
  static class Node {
    TNode node;
    int i;
    public Node(TNode node, int i) {
      this.node = node;
      this.i = i;
    }
  }
  public static int find(TNode root, int depth, int other) {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(root, 0));
    int d = 0;
    while (!q.isEmpty()) {
      Node cur = q.poll();
      if (cur.i == depth)
        d++;
      if (d == other)
        return cur.node.val;
      q.add(new Node(cur.node.left, cur.i + 1));
      q.add(new Node(cur.node.right, cur.i + 1));
    }
    return -1;
  }
  /*
       3
    2    5
  1  4  6  8
  */
  public static int find1(TNode root, int depth, int other) {
    int h = 0;
    int d = 0;
    while (d <= other) {
      if (root == null) {
        root = root.prev;
        h--;
        continue;
      }
      if (h == depth) {
        if (d == other)
          return root.val;
        d++;
      }
      if (h == depth || (root.left == null && root.right == null)) {
        TNode cur = root.prev;
        if (cur.left == root)
          cur.left = null;
        else cur.right = null;
        root = cur;
        h--;
        continue;
      }
      if (root.left != null)
        root = root.left;
      else root = root.right;
      h++;
    }
    return root.val;
  }
  public static int find3(TNode root, int depth, int other) {
    for (int i = depth - 1; i >= 0; i--) {
      int bit = (other >> i) & 1;
      if (bit == 0) {
        root = root.left;
      } else {
        root = root.right;
      }
      if (root == null) {
        return -1;
      }
    }
    return root.val;
  }
  public static int find4(TNode root, int depth, int other) {
    TNode current = root;
    for (int i = depth - 1; i >= 0; i--) {
      int bit = (other >> i) & 1;
      if (bit == 0) {
        if (current.left != null) {
          current = current.left;
        } else {
          // Если левый узел отсутствует, возвращаемся к prev и пробуем еще раз
          while (current != null && current.left == null) {
            current = current.prev;
          }
          if (current != null) {
            current = current.left;
          } else {
            return -1; // Узел не найден
          }
        }
      } else {
        if (current.right != null) {
          current = current.right;
        } else {
          while (current != null && current.right == null) {
            current = current.prev;
          }
          if (current != null) {
            current = current.right;
          } else {
            return -1; // Узел не найден
          }
        }
      }
      if (current == null) {
        return -1; // Если узел не найден
      }
    }
    return current.val;
  }
  public static int find5(TNode root, int depth, int other) {
    return 0;
  }
}
