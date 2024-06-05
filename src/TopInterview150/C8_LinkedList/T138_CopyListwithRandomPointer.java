// https://leetcode.com/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C8_LinkedList;
import java.util.*;
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
    Node y=new Node(7);
    Node z=y;
    z.next=new Node(13);
    z=z.next;
    z.next=new Node(11);
    z=z.next;
    z.next=new Node(10);
    z=z.next;
    z.next=new Node(1);
    z=y;
    z=z.next;
    z.random=y;
    z=z.next;
    Node z1=z;
    z=z.next;
    z.random=z1;
    z=z.next;
    z1.random=z;
    Node x=copyRandomList1(y);
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
  public static Node copyRandomList1(Node head) {
    Map<Node,Node> map=new HashMap<>();
    Node ans=new Node(0);
    Node cur=ans;
    Node x=head;
    while(x!=null){
      cur.val=x.val;
      map.put(x,cur);
      if (x.next!=null){
        cur.next=new Node(0);
        cur=cur.next;
      }
      x=x.next;
    }
    cur=ans;
    x=head;
    while(x!=null){
      cur.random=map.get(x.random);
      cur=cur.next;
      x=x.next;
    }
    return ans;
  }
}
