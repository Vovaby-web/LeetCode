package Lessons.LeetCode.Yandex.L1_LinkedList;
public class T206_BackList {
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
    ListNode l1 = new ListNode(1);
    ListNode next = new ListNode(2);
    l1.next = next;
    next = l1.next;
    next.next = new ListNode(3);
    ListNode l = reverseList(l1);
    ListNode pr = l;
    while (pr != null) {
      System.out.print(pr.val + " ");
      pr = pr.next;
    }
  }
  public static ListNode reverseList(ListNode head) {
    ListNode node=null;
    while (head!=null){
      ListNode next=new ListNode(head.val);
      next.next=node;
      node=next;
      head=head.next;
    }
    return node;
  }
}
