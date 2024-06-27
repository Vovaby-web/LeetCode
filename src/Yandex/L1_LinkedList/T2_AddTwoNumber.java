// https://leetcode.com/problems/add-two-numbers/description/
package Yandex.L1_LinkedList;
import java.util.Arrays;
public class T2_AddTwoNumber {
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
  }
  public static void main(String[] args) {
    ListNode l1 = new ListNode(9);
    ListNode next = new ListNode(9);
    l1.next = next;
    next = l1.next;
    next.next = new ListNode(9);
    ListNode l2 = new ListNode(9);
    next = new ListNode(9);
    l2.next = next;
    // next.next = new ListNode(9);
    ListNode l = addTwoNumbers1(l1, l2);
    ListNode pr = l;
    while (pr != null) {
      System.out.print(pr.val + " ");
      pr = pr.next;
    }
  }
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode node = null;
    ListNode current = node;
    // Наши десятки
    int x = 0;
    while (l1 != null || l2 != null) {
      // Если существует значения в обоих списках
      if (l1 != null && l2 != null) {
        // Новое значение = значения из обеих списков + 1 с предыдкщего значения или 0
        ListNode prev = new ListNode((l1.val + l2.val + x) % 10);
        if (node == null) {
          // Если наш список был пуст
          node = prev;
          current = node;
        } else {
          // Если не пуст
          current.next = prev;
          current = current.next;
        }
        // Если наш результат больше 10
        x = (l1.val + l2.val + x) / 10;
        // Переходим к следующим элементам
        l1 = l1.next;
        l2 = l2.next;
        // Если у нас только один список
      } else if (l1 != null) {
        ListNode prev = new ListNode((l1.val + x) % 10);
        if (node == null) {
          node = prev;
          current = node;
        } else {
          current.next = prev;
          current = current.next;
        }
        x = (l1.val + x) / 10;
        l1 = l1.next;
        // Если у нас только второй список
      } else if (l2 != null) {
        ListNode prev = new ListNode((l2.val + x) % 10);
        if (node == null) {
          node = prev;
          current = node;
        } else {
          current.next = prev;
          current = current.next;
        }
        x = (l2.val + x) / 10;
        l2 = l2.next;
      }
    }
    if (x == 1) {
      ListNode prev = new ListNode(1);
      current.next = prev;
    }
    return node;
  }
  public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    if (l1==null&&l2==null)
      return null;
    ListNode ans=new ListNode(0);
    ListNode cur=ans;
    int x=0;
    while(l1!=null||l2!=null){
      if (l1!=null&&l2==null){
        int y=l1.val+x;
        if (y>9){
          y=y%10;
          x=1;
        }else x=0;
        cur.next=new ListNode(y);
        cur=cur.next;
        l1=l1.next;
      }else if (l1==null&&l2!=null){
        int y=l2.val+x;
        if (y>9){
          y=y%10;
          x=1;
        }else x=0;
        cur.next=new ListNode(y);
        cur=cur.next;
        l2=l2.next;
      }else {
        int y=l1.val+l2.val+x;
        if (y>9){
          y=y%10;
          x=1;
        }else x=0;
        cur.next=new ListNode(y);
        cur=cur.next;
        l2=l2.next;
        l1=l1.next;
      }
    }
    if (x==1)
      cur.next=new ListNode(1);
    return ans.next;
  }
}
