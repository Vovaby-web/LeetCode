// https://leetcode.com/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C8_LinkedList;
public class T86_PartitionList {
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
    System.out.println(partition(new ListNode(1, new ListNode(2, new ListNode(3,
       new ListNode(4, new ListNode(5))))), 2));
  }
  public static ListNode partition(ListNode head, int x) {
    ListNode ans = new ListNode(0, head);
    ListNode cur = ans;
    if (head == null || head.next == null)
      return head;
    while (cur.next != null && cur.next.val < x) {
      cur = cur.next;
    }
    ListNode pre = cur;
    while (cur.next != null) {
      if (cur.next.val < x) {
        ListNode t = cur.next;
        cur.next = cur.next.next;
        t.next = pre.next;
        pre.next = t;
        pre = pre.next;
      } else cur = cur.next;
    }
    return ans.next;
  }
}
