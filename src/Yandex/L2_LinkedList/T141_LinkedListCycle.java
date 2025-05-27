package Tasks.LeetCode.Yandex.L2_LinkedList;
public class T141_LinkedListCycle {
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
  public static void main(String[] args) {
   ListNode head = new ListNode(3);
   ListNode head1 = new ListNode(2);
   head.next = head1;
   head1.next = new ListNode(0);
   head1.next.next = new ListNode(-4);
   head1.next.next.next = head1;
    System.out.println(hasCycle(head));
  }
  public static boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (slow.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast)
        return true;
    }
    return false;
  }
}
