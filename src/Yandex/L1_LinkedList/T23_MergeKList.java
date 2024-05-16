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
    TreeSet<Integer> set = new TreeSet<>();
    if (lists.length > 0) {
      for (ListNode i : lists) {
        if (i != null) {
          // ������ ������ �� ������ ������� i-�� ������
          ListNode current = i;
          // ���� ������ ����������
          while (current != null) {
           // ����� ������ ��������
            int x = current.val;
            // ���� ��� ������ ����������� ����
            if (node == null) {
              // ����� ������� ��� ������ ����������� �� ��������� ����� ����������
              node = new ListNode(x);
            } else {
              // ����� ������ ������ �� ������ ������� ������ ������ �����������
              ListNode insert = node;
              // ���� ������ ������� ������ ������ ����������� <= ������ �������� ��������
              if (insert.val <= x) {
                // ����� ������� ������ �� ������ ������� ������ �����������
                ListNode prev = insert;
                // ������ ���� ���� �������� � ������ ����������� ������ �������� � ��������� ������
                while (insert.val <= x) {
                  // ������ �� ��������, ������� ������ ���� ����� ������ ��������� �������� x
                  prev = insert;
                  // ���� ���������� �������� �� ���������� � ������ �����������, ����� ������� �� �����
                  if (insert.next == null)
                    break;
                  // ������ �� ��������, ������� �� ��������� ����� ����� ������ ������ ��������� �������� x
                  insert = insert.next;
                }
                // ������� ������ � �������� ��������� - x
                ListNode next = new ListNode(x);
                // ��������� � ��� ����� ������ next ��� ��������, ������� ������ ������ �������� x
                next.next = prev.next;
                // ��������� � �������� �������� ���� ��� ������ ����� ������ next
                prev.next = next;
              } else {
                // ���� ������ ������� ������ ������ ����������� > ������ �������� ��������
                // ������� ������ � �������� ��������� - x
                ListNode prev = new ListNode(x);
                // ��������� � ��� ����� ������ prev ��� �������� c ������ ������ �����������
                prev.next = insert;
                // � ������ � ��� ����� ������ �����������
                node = prev;
              }
            }
            current = current.next;
          }
        }
      }
    }
    return node;
  }
}
