// https://leetcode.com/problems/merge-k-sorted-lists/description/
package Yandex.L1_LinkedList;
import java.util.TreeSet;
public class T23_MergeKList {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
  public static void main(String[] args) {
    // ������� ��� ������
    ListNode[] l = {new ListNode(1, new ListNode(4, new ListNode(5))),
       new ListNode(1, new ListNode(3, new ListNode(4))),
       new ListNode(2, new ListNode(6))};
    ListNode[] l1 = {new ListNode(1),
       new ListNode(0)};
    ListNode node = mergeKLists(l);
    ListNode print = node;
    while (print != null) {
      System.out.print(print.val + " ");
      if (print.next == null)
        break;
      print = print.next;
    }
  }
  public static ListNode mergeKLists(ListNode[] lists) {
    ListNode node = null;
    if (lists.length == 0)
      return node;
    TreeSet<Integer> set = new TreeSet<>();
    for (ListNode i : lists) {
      if (i != null) {
        ListNode cur = i;               // ������ ������ �� ������ ������� i-�� ������
        while (cur != null) {           // ���� ������ ����������
          int x = cur.val;              // ����� ������ ��������
          if (node == null) {           // ���� ��� ������ ����������� ����
            node = new ListNode(x);     // ����� ������� ��� ������ ����������� �� ��������� ����� ����������
          } else {
            ListNode insert = node;     // ����� ������ ������ �� ������ ������� ������ ������ �����������
            if (insert.val <= x) {      // ���� ������ ������� ������ ������ ����������� <= ������ �������� ��������
              ListNode prev = insert;   // ����� ������� ������ �� ������ ������� ������ �����������
              while (insert.val <= x) { // ������ ���� ���� �������� � ������ ����������� ������ �������� � ��������� ������
                prev = insert;          // ������ �� ��������, ������� ������ ���� ����� ������ ��������� �������� x
                if (insert.next == null)// ���� ���������� �������� �� ���������� � ������ �����������, ����� ������� �� �����
                  break;
                insert = insert.next;   // ������ �� ��������, ������� �� ��������� ����� ����� ������ ������ ��������� �������� x
              }
              ListNode next = new ListNode(x); // ������� ������ � �������� ��������� - x
              next.next = prev.next;           // ��������� � ��� ����� ������ next ��� ��������, ������� ������ ������ �������� x
              prev.next = next;                // ��������� � �������� �������� ���� ��� ������ ����� ������ next
            } else { // ���� ������ ������� ������ ������ ����������� > ������ �������� �������� ������� ������ � �������� ��������� - x
              ListNode prev = new ListNode(x);
              prev.next = insert;      // ��������� � ��� ����� ������ prev ��� �������� c ������ ������ �����������
              node = prev;             // � ������ � ��� ����� ������ �����������
            }
          }
          cur = cur.next;
        }
      }
    }
    return node;
  }
  public static ListNode mergeKLists1(ListNode[] lists) {
    ListNode ans = new ListNode(0);
    if (lists.length == 0)
      return null;
    ListNode cur = ans;
    for (int i = 0; i < lists.length; i++) {
      ListNode node = lists[i];
      cur = ans;
      while (node != null) {
        if (cur.next == null) {
          ListNode t = node.next;
          node.next = null;
          cur.next = node;
          node = t;
          cur = cur.next;
        } else if (cur.next.val > node.val) {
          ListNode t = node.next;
          node.next = cur.next;
          cur.next = node;
          node = t;
        } else if (cur.next.val <= node.val) {
          cur = cur.next;
        }
      }
    }
    return ans.next;
  }
}
