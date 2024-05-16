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
    TreeSet<Integer> set = new TreeSet<>();
    if (lists.length > 0) {
      for (ListNode i : lists) {
        if (i != null) {
          // Делаем ссылку на первый элемент i-го списка
          ListNode current = i;
          // Если объект существует
          while (current != null) {
           // Берем первое значение
            int x = current.val;
            // Если наш список результатов пуст
            if (node == null) {
              // Тогда создаем наш список результатов со значением нашей переменной
              node = new ListNode(x);
            } else {
              // Иначе делаем ссылку на первый элемент нашего списка результатов
              ListNode insert = node;
              // Если первый элемент нашего списка результатов <= нашего текущего элемента
              if (insert.val <= x) {
                // Тогда создаем ссылку на первый элемент списка результатов
                ListNode prev = insert;
                // Делаем цикл пока значение в списке результатов меньше значения с исходного списка
                while (insert.val <= x) {
                  // Ссылка на значение, которое меньше либо равно нашего исходного значения x
                  prev = insert;
                  // Если следующего элемента не существует в списке результатов, тогда выходим из цикла
                  if (insert.next == null)
                    break;
                  // Ссылка на значение, которое по окончании цикла будет больше нашего исходного значения x
                  insert = insert.next;
                }
                // Создаем объект с исходным значением - x
                ListNode next = new ListNode(x);
                // Добавляем в наш новый список next все элементы, которые больше нашего значения x
                next.next = prev.next;
                // Добавляем к текущему значению весь наш список новый список next
                prev.next = next;
              } else {
                // Если первый элемент нашего списка результатов > нашего текущего элемента
                // Создаем объект с исходным значением - x
                ListNode prev = new ListNode(x);
                // Добавляем в наш новый список prev все элементы c нашего списка результатов
                prev.next = insert;
                // И теперь у нас новый список результатов
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
