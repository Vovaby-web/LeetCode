package Tasks.LeetCode.Yandex.L2_LinkedList;

public class T2_AddTwoNumbers {
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
    System.out.println(addTwoNumbers(l1, l2));
  }
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode ans = new ListNode(0);
    ListNode cur = ans;
    int x = 0;
    while (l1 != null && l2 != null) {
      int res = l1.val + l2.val + x;
      if (res / 10 == 0) {
        x = 0;
      } else {
        x = 1;
        res %= 10;
      }
      cur.next = new ListNode(res);
      cur = cur.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      int res = l1.val + x;
      if (res / 10 == 0) {
        x = 0;
      } else {
        x = 1;
        res %= 10;
      }
      cur.next = new ListNode(res);
      cur = cur.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      int res = l2.val + x;
      if (res / 10 == 0) {
        x = 0;
      } else {
        x = 1;
        res %= 10;
      }
      cur.next = new ListNode(res);
      cur = cur.next;
      l2 = l2.next;
    }
    if (x > 0) {
      cur.next = new ListNode(x);
    }
    return ans.next;
  }
}
