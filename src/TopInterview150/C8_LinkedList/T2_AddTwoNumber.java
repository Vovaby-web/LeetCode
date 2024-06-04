// https://leetcode.com/problems/add-two-numbers/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C8_LinkedList;
public class T2_AddTwoNumber {
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
  }
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    ListNode next = new ListNode(4);
    l1.next = next;
    next = l1.next;
    next.next = new ListNode(3);
    ListNode l2 = new ListNode(5);
    next = new ListNode(6);
    l2.next = next;
    next.next = new ListNode(4);
    ListNode l = addTwoNumbers(l1, l2);
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
}
