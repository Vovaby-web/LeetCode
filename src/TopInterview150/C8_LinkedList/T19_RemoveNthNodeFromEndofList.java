// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C8_LinkedList;
public class T19_RemoveNthNodeFromEndofList {
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
   public static void main(String[] args) {
    System.out.println(removeNthFromEnd(new ListNode(1, new ListNode(2)), 2));
  }
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode cur=head;
    int m=0;
    if (head==null)
      return head;
    if (head.next==null)
      return null;
    while(cur!=null){
      m++;
      cur=cur.next;
    }
    cur=head;
    n=m-n;
    if (n==1)
      return head.next;
    m=1;
    while(m!=n){
      cur=cur.next;
      m++;
    }
    ListNode c=cur.next;
    cur.next=c.next;
    return head;
  }
}
