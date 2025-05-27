package Tasks.LeetCode.Yandex.L2_LinkedList;
public class T206_ReverseLinkedList {
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
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
    System.out.println(reverseList(head));
  }
  public static ListNode reverseList(ListNode head) {
    if (head == null)
      return null;
    ListNode ans = null;
    while (head != null) {
      ListNode temp = head.next;
      head.next = ans;
      ans = head;
      head = temp;
    }
    return ans;
  }
}
