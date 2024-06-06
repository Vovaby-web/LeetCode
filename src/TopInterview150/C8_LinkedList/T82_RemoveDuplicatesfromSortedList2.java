// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C8_LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class T82_RemoveDuplicatesfromSortedList2 {
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
    System.out.println(deleteDuplicates(new ListNode(1, new ListNode(1))));
  }
  public static ListNode deleteDuplicates(ListNode head) {
    ListNode ans = new ListNode(0, head);
    ListNode pre = ans;
    ListNode cur = head;
    while (cur != null) {
      while (cur.next != null && cur.next.val == cur.val) {
        cur = cur.next;
      }
      if (pre.next == cur)
        pre = cur;
       else pre.next = cur.next;
      cur = cur.next;
    }
    return ans.next;
  }
}
