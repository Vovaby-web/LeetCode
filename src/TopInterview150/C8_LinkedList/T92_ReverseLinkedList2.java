// https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C8_LinkedList;
import java.util.*;
public class T92_ReverseLinkedList2 {
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
    System.out.println(reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3,
       new ListNode(4, new ListNode(5, new ListNode(6)))))), 2, 5));
  }
  public static ListNode reverseBetween(ListNode head, int left, int right) {
    if (head.next == null || left == right) {
      return head;
    }
    ListNode ans = new ListNode(0, head);
    ListNode pre = ans;
    for (int i = 0; i < left - 1; i++) {
      pre = pre.next;
    }
    ListNode l = pre;
    ListNode r = pre.next;
    ListNode cur = pre.next;
    for (int i = 0; i < right - left + 1; i++) {
      ListNode t = cur.next;
      cur.next = pre;
      pre = cur;
      cur = t;
    }
    l.next = pre;
    r.next = cur;
    return ans.next;
  }
  public static ListNode reverseBetween1(ListNode head, int left, int right) {
    List<Integer> list=new ArrayList<>();
    ListNode curh=head;
    int i=1;
    while(curh!=null){
      if (i>=left&&i<=right){
        list.add(curh.val);
      }
      curh=curh.next;
      i++;
    }
    curh=head;
    Collections.reverse(list);
    i=1;
    int j=0;
    while(curh!=null){
      if (i>=left&&i<=right){
        curh.val=list.get(j++);
      }
      curh=curh.next;
      i++;
    }
    return head;
  }
}

