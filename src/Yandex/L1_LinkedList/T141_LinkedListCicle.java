// https://leetcode.com/problems/linked-list-cycle/description/
package Yandex.L1_LinkedList;
import java.util.*;
public class T141_LinkedListCicle {
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
  public static void main(String[] args) {
    ListNode cicle = new ListNode(3);
    ListNode next = new ListNode(2);
    cicle.next = next;
    System.out.print(hasCycle(cicle));
  }
  /* public static boolean hasCycle(ListNode head) {
     // � ������� ������� ���� ���������� hashCode
     // C������ ������ hashCode
     TreeSet<Integer> set = new TreeSet<>();
     while (head != null && head.next != null) {
       // ����� hashCode �������
       int x = head.hashCode();
       // � ���������� � ��������� ������� hashCode
       if (set.contains(x)) {
         return true;
       } else {
         // ���� ������ ���, �� ��������� ��� � ������
         set.add(x);
         // ��������� ������
         head = head.next;
       }
     }
     return false;
   }*/
  public static boolean hasCycle(ListNode head) {
    // ������ �� ������ � ����� � ���� ������
    ListNode slow = head;
    // ������ �� ������ � ����� � ��� ������
    ListNode fast = head;
    // ���� ���������� ���� � ��������� ������
    while (fast != null && fast.next != null) {
      // ������� ������ �� ��������� ������
      slow = slow.next;
      // ������� ������ �� ��� ���� ������ �.�. ������ head.next=null � ������������
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
