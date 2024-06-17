import java.util.*;
public class Test {
  //  Этот класс представляет ориентированный граф с использованием списка смежности
  static class Graph {
    private int v;  // Количество вершин
    private LinkedList<Integer> mat[]; // Список смежности
    // Конструктор
    Graph(int v) {
      this.v = v;
      mat = new LinkedList[v];
      for (int i = 0; i < v; i++)
        mat[i] = new LinkedList();
    }
    // Функция для добавления ребра в граф
    void addEdge(int v, int w) {
      mat[v].add(w);
    }
    // Рекурсивная функция, используемая topologicalSort
    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
      //  Помечаем текущий узел как посещенный
      visited[v] = true;
      Integer i;
      // Рекурсивно вызываем функцию для всех смежных вершин
      Iterator<Integer> it = mat[v].iterator();
      while (it.hasNext()) {
        i = it.next();
        if (!visited[i])
          topologicalSortUtil(i, visited, stack);
      }
      // Добавляем текущую вершину в стек с результатом
      stack.push(v);
    }
    // Функция для поиска топологической сортировки.
    // Рекурсивно использует topologicalSortUtil()
    void topologicalSort() {
      Stack<Integer> stack = new Stack();
      // Помечаем все вершины как непосещенные
      boolean visited[] = new boolean[v];
      for (int i = 0; i < v; i++)
        visited[i] = false;
      // Вызываем рекурсивную вспомогательную функцию
      // для поиска топологической сортировки для каждой вершины
      for (int i = 0; i < v; i++)
        if (visited[i] == false)
          topologicalSortUtil(i, visited, stack);
      // Выводим содержимое стека
      while (stack.empty() == false)
        System.out.print(stack.pop() + " ");
    }
    // Программа для тестирования
    public static void main(String args[]) {
      // Создаем граф, приведенный на диаграмме выше
      Graph g = new Graph(6);
      g.addEdge(5, 2);
      g.addEdge(5, 0);
      g.addEdge(4, 0);
      g.addEdge(4, 1);
      g.addEdge(2, 3);
      g.addEdge(3, 1);

      System.out.println("Following is a Topological " +
         "sort of the given graph");
      g.topologicalSort();
    }
  }
}
