// https://leetcode.com/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C8_LinkedList;
import java.util.HashMap;
import java.util.Map;
public class T138_CopyListwithRandomPointer {
  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
  public static void main(String[] args) {
  }
  public static Node copyRandomList(Node head) {
    Map<Node, Node> d = new HashMap<>();
    Node dummy = new Node(0);
    Node tail = dummy;
    for (Node cur = head; cur != null; cur = cur.next) {
      tail.next = new Node(cur.val);
      tail = tail.next;
      d.put(cur, tail);
    }
    tail = dummy.next;
    for (Node cur = head; cur != null; cur = cur.next) {
      tail.random = d.get(cur.random);
      tail = tail.next;
    }
    return dummy.next;
  }
}
