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
    System.out.println(reverseBetween(new ListNode(3, new ListNode(5)), 1, 2));
  }
  public static ListNode reverseBetween(ListNode head, int left, int right) {
    if (head.next == null || left == right) {
      return head;
    }
    ListNode ans = new ListNode(0,head);
    ListNode prev = ans;
    int i = 0;
    while (i < left - 1) {
      prev = prev.next;
      i++;
    }
    ListNode l = prev;
    ListNode r = prev.next;
    ListNode curr = prev.next;
    i=0;
    while (i < right - left + 1) {
      ListNode t = curr.next;
      curr.next = prev;
      prev = curr;
      curr = t;
      i++;
    }
    l.next = prev;
    r.next = curr;
    return ans.next;
  }
}
