// https://leetcode.com/problems/sort-list/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C16_DivideConquer;
public class T148_SortList {
  static class ListNode {
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
    System.out.println(sortList(new ListNode(4, new ListNode(1,
       new ListNode(3, new ListNode(8, new ListNode(10,
          new ListNode(9))))))));
  }
 // —ложность O(n log n), где n Ч количество узлов в св€занном списке
  static ListNode sortList(ListNode head) {
   if (head == null || head.next == null)
      return head;
    ListNode mid = find_mid(head);
    ListNode left = sortList(head);
    ListNode right = sortList(mid);
    return merge_sort(left, right);
  }
  private static ListNode find_mid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode mid = slow.next;
    slow.next = null;
    return mid;
  }
  static ListNode merge_sort(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(-1);
    ListNode current = dummy;
    while (left != null && right != null) {
      if (left.val <= right.val) {
        current.next = left;
        left = left.next;
      } else {
        current.next = right;
        right = right.next;
      }
      current = current.next;
    }
    if (left != null)
      current.next = left;
    if (right != null)
      current.next = right;
    return dummy.next;
  }
}
