package Tasks.LeetCode.Yandex.L2_LinkedList;
public class T234_PalindromeLinkedList {
  public static class ListNode {
    int val;
    ListNode next;
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
    System.out.println(isPalindrome(head));
  }
  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null)
      return true;
    ListNode current = head;
    ListNode end = head;
    while (end != null && end.next != null) {
      current = current.next;
      end = end.next.next;
    }
    ListNode previous = null;
    while (current != null) {
      ListNode temp = current.next;
      current.next = previous;
      previous = current;
      current = temp;
    }
    while (previous != null && head != null) {
      if (previous.val != head.val)
        return false;
      previous = previous.next;
      head = head.next;
    }
    return true;
  }
}

