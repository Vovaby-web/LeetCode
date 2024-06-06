// https://leetcode.com/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C8_LinkedList;
public class T25_ReverseNodesinkGroup {
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
    ListNode prev = ans;
    ListNode curr = ans;
    while (curr.next != null) {
      for (int i = 0; i < k && curr != null; i++) {
        curr = curr.next;
      }
      if (curr == null) {
        return ans.next;
      }
      ListNode t = curr.next;
      curr.next = null;
      ListNode start = prev.next;
      prev.next = reverseList(start);
      start.next = t;
      prev = start;
      curr = prev;
    }
    return ans.next;
  }
  private static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode p = head;
    while (p != null) {
      ListNode t = p.next;
      p.next = prev;
      prev = p;
      p = t;
    }
    return prev;
  }
  public static ListNode reverseKGroup1(ListNode head, int k) {
    ListNode ans = new ListNode(0, head);
    ListNode l = head;
    int n = 0;
    while (l != null) {
      l = l.next;
      n++;
    }
    l = ans;
    int m = n / k;
    for (int i = 0; i < m; i++) {
      ListNode r = l.next;
      ListNode p = l;
      ListNode c = l.next;
      int j = 0;
      while (j < k) {
        ListNode t = c.next;
        c.next = p;
        p = c;
        c = t;
        j++;
      }
      l.next = p;
      r.next = c;
      l = r;
    }
    return ans.next;
  }
}
