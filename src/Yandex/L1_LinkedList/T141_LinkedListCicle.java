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
     // У каждого объекта свой уникальный hashCode
     // Cоздаем список hashCode
     TreeSet<Integer> set = new TreeSet<>();
     while (head != null && head.next != null) {
       // Берем hashCode объекта
       int x = head.hashCode();
       // И сравниваем с имеющимся списком hashCode
       if (set.contains(x)) {
         return true;
       } else {
         // Если номера нет, то добавляем его в список
         set.add(x);
         // Двигаемся дальше
         head = head.next;
       }
     }
     return false;
   }*/
  public static boolean hasCycle(ListNode head) {
    // Ссылка на объект с шагом в одну клетку
    ListNode slow = head;
    // Ссылка на объект с шагом в две клетки
    ListNode fast = head;
    // Если существует этот и следующий объект
    while (fast != null && fast.next != null) {
      // Двигаем ссылку на следующий объект
      slow = slow.next;
      // Двигаем ссылку на два шага вперед т.к. объект head.next=null в конструкторе
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
