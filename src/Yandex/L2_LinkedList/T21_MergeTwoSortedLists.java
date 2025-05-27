package Tasks.LeetCode.Yandex.L2_LinkedList;
public class T21_MergeTwoSortedLists {
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
    ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    System.out.println(mergeTwoLists(l1, l2));
  }
  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode ans = new ListNode(0);
    ListNode cur = ans;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        ListNode temp = list1.next;
        list1.next = null;
        cur.next = list1;
        cur = cur.next;
        list1 = temp;
      } else {
        ListNode temp = list2.next;
        list2.next = null;
        cur.next = list2;
        cur = cur.next;
        list2 = temp;
      }
    }
    while (list1 != null) {
      ListNode temp = list1.next;
      list1.next = null;
      cur.next = list1;
      cur = cur.next;
      list1 = temp;
    }
    while (list2 != null) {
      ListNode temp = list2.next;
      list2.next = null;
      cur.next = list2;
      cur = cur.next;
      list2 = temp;
    }
    return ans.next;
  }
}
