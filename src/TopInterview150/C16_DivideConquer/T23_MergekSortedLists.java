// https://leetcode.com/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C16_DivideConquer;
import java.util.TreeSet;
public class T23_MergekSortedLists {
 static class ListNode {
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
    // Создаем наш список
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
        ListNode cur = i;               // Делаем ссылку на первый элемент i-го списка
        while (cur != null) {           // Если объект существует
          int x = cur.val;              // Берем первое значение
          if (node == null) {           // Если наш список результатов пуст
            node = new ListNode(x);     // Тогда создаем наш список результатов со значением нашей переменной
          } else {
            ListNode insert = node;     // Иначе делаем ссылку на первый элемент нашего списка результатов
            if (insert.val <= x) {      // Если первый элемент нашего списка результатов <= нашего текущего элемента
              ListNode prev = insert;   // Тогда создаем ссылку на первый элемент списка результатов
              while (insert.val <= x) { // Делаем цикл пока значение в списке результатов меньше значения с исходного списка
                prev = insert;          // Ссылка на значение, которое меньше либо равно нашего исходного значения x
                if (insert.next == null)// Если следующего элемента не существует в списке результатов, тогда выходим из цикла
                  break;
                insert = insert.next;   // Ссылка на значение, которое по окончании цикла будет больше нашего исходного значения x
              }
              ListNode next = new ListNode(x); // Создаем объект с исходным значением - x
              next.next = prev.next;           // Добавляем в наш новый список next все элементы, которые больше нашего значения x
              prev.next = next;                // Добавляем к текущему значению весь наш список новый список next
            } else { // Если первый элемент нашего списка результатов > нашего текущего элемента Создаем объект с исходным значением - x
              ListNode prev = new ListNode(x);
              prev.next = insert;      // Добавляем в наш новый список prev все элементы c нашего списка результатов
              node = prev;             // И теперь у нас новый список результатов
            }
          }
          cur = cur.next;
        }
      }
    }
    return node;
  }
}
