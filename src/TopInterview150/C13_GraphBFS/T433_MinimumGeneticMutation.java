// https://leetcode.com/problems/minimum-genetic-mutation/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C13_GraphBFS;
import java.util.*;
public class T433_MinimumGeneticMutation {
  public static void main(String[] args) {
    System.out.println(minMutation("AACCGGTT", "AAACGGTA",
       new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
  }
  // Мы можем видеть каждую строку как узел и можем соединить их, если
  // 1. отличается только один символ
  // 2. целевой узел доступен в `bank`
  // проблема теперь в том, чтобы найти кратчайший путь от начальной точки до конечной точки
  // для использования BFS
  public static int minMutation(String start, String end, String[] bank) {
      // очередь для хранения каждой строки гена (узел)
      Queue<String> q = new LinkedList<>();
      // хэш, который будет храниться, если мы посетили узел
      HashSet<String> vis = new HashSet<String>();
      // конвертируем банк в список
      List<String> banks = Arrays.asList(bank);
      // расстояние
      int steps = 0;
      // мы начинаем с генной строки "start" в качестве отправной точки
      // помещаем узел в очередь
      q.add(start);
      // и отмечаем его как посещенный
      vis.add(start);
      // BFS
      while (!q.isEmpty()) {
        // Итерация с конца, потому что размер q меняется,
        // что приведет к неправильному ответу, если вы выполните итерацию от 0
        // альтернативно, вы можете определить новую переменную для q.size() перед циклом for
        // т.е.
        // int n = q.size();
        // for (int i = 0; i < n; i++) {
        for (int i = q.size(); i > 0; i--) {
          // получаем строку (узел) гена из очереди
          String s = q.poll();
          // если это тоже самое, что и "end", то мы нашли ответ
          if (s.equals(end))
            return steps;
          // в противном случае, если задана генная строка длиной 8 символов
          // мы можем заменить каждый символ на «A», «C», «G» и «T»
          char[] ca = s.toCharArray();
          for (int j = 0; j < 8; j++) {
            // s[j] будет изменено позже, следовательно, сохраняем здесь исходный символ
            char oc = ca[j];
            // повторяем ACGT
            // альтернативно вы можете использовать `for (char c : "ACGT") { ...}
            for (int k = 0; k < 4; k++) {
              // заменяем j-й символ в s на k-й символ в ACGT
              ca[j] = "ACGT".charAt(k);
              // мы можем достичь следующего узла, если следующий узел еще не был посещен
              // и следующий узел доступен в "bank"
              String t = new String(ca);
              if (!vis.contains(t) && banks.contains(t)) {
                // помещаем следующий узел в очередь
                q.add(t);
                // делаем его посещенным
                vis.add(t);
              }
            }
            // раз уж мы обновили персонажа, то возвращаем его обратно
            ca[j] = oc;
          }
        }
        // увеличиваем количество шагов
        steps += 1;
      }
      // невозможно достичь `end`, верните здесь -1
      return -1;
    }
  }
