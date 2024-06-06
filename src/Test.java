import java.util.*;
public class Test {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
      this.val = val;
    }
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
  public static void main(String[] args) {
    System.out.println(reverseKGroup(new ListNode(1, new ListNode(2,
       new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
  }
  public static ListNode reverseKGroup(ListNode head, int k) {
    ListNode ans = new ListNode(0, head);
    ListNode pre = ans;
    ListNode cur = ans;
    while (cur != null) {
      for (int i = 0; i < k && cur != null; i++)
        cur = cur.next;
      if (cur==null)
        return ans.next;
      ListNode t=cur.next;
      cur.next=null;
      ListNode r=pre.next;
      pre.next=reverse(pre);
      pre=r;
      pre.next=t;
    }
    return ans.next;
  }
  public static ListNode reverse(ListNode head) {
    ListNode pre = head;
    ListNode cur = head.next;
    while(cur!=null){
      ListNode t=cur.next;
      cur.next=pre;
      pre=cur;
      cur=t;
    }
    return pre;
  }
}
