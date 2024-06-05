// https://leetcode.com/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C8_LinkedList;
public class T25_ReverseNodesinkGroup {
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
    System.out.println(reverseKGroup(new ListNode(1, new ListNode(2,
       new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
  }
  public static ListNode reverseKGroup(ListNode head, int k) {
    ListNode ans = new ListNode(0, head);
    ListNode l = ans;
    while (l.next != null) {
      ListNode r = l.next;
      ListNode p = l;
      ListNode c = l.next;
      int i = 0;
      while (i < k && c != null) {
        ListNode t = c.next;
        c.next = p;
        p = c;
        c = t;
        i++;
      }
      if (i < k){
        r.next = c;
        break;
      }
      l.next = p;
      r.next = c;
      l = r;
    }
    return ans.next;
  }
}
