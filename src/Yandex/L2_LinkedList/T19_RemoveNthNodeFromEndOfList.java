package Tasks.LeetCode.Yandex.L2_LinkedList;
public class T19_RemoveNthNodeFromEndOfList {
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
    ListNode head = new ListNode(1, new ListNode(2,
       new ListNode(1)));
    System.out.println(removeNthFromEnd(head, 2));
  }
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode first = new ListNode();
    first.next = head;
    int m = 1;
    while (head.next != null) {
      head = head.next;
      m++;
    }
    ListNode current = first;
    int k = 0;
    while (current.next != null) {
      if (k == m - n) {
        current.next = current.next.next;
        break;
      }
      current = current.next;
      k++;
    }
    return first.next;
  }
}
