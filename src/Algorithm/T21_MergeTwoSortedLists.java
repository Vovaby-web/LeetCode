// https://leetcode.com/problems/merge-two-sorted-lists/
package Algorithm;
public class T21_MergeTwoSortedLists {
  public static class ListNode {
    int val;
    ListNode next;
    public ListNode() {
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
    System.out.println(mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
       new ListNode(1, new ListNode(3, new ListNode(4)))));
  }
  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null)
      return null;
    ListNode list = new ListNode();
    ListNode curr = list;
    while (list1 != null || list2 != null) {
      if (list1 != null && list2 == null) {
        curr.val = list1.val;
        list1 = list1.next;
      } else if (list1 == null && list2 != null) {
        curr.val = list2.val;
        list2 = list2.next;
      } else {
        if (list1.val < list2.val) {
          curr.val = list1.val;
          list1 = list1.next;
        } else {
          curr.val = list2.val;
          list2 = list2.next;
        }
      }
      if (list1 != null || list2 != null) {
        curr.next = new ListNode();
        curr = curr.next;
      }
    }
    return list;
  }
}
