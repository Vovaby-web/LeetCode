// https://leetcode.com/problems/rotate-list/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C8_LinkedList;
public class T61_RotateList {
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
    System.out.println(rotateRight(new ListNode(1, new ListNode(2, new ListNode(3,
      new ListNode(4,new ListNode(5))))), 2));
  }
  public static ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    int n = 0;
    for (; cur != null; cur = cur.next) {
      n++;
    }
    k %= n;
    if (k == 0) {
      return head;
    }
    cur = head;
    ListNode pre = head;
    while (k-- > 0) {
      cur = cur.next;
    }
    while (cur.next != null) {
      cur = cur.next;
      pre = pre.next;
    }
    ListNode ans = pre.next;
    pre.next = null;
    cur.next = head;
    return ans;
  }
}
