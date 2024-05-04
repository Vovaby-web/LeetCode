// https://leetcode.com/problems/sliding-window-median/description/
package Yandex.L9_SlidingWindow.T480;
import java.util.*;
public class T480_SlidingWindowMedian {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(medianSlidingWindow2(new int[]{1,2,3,4}, 3)));
  }
  // Сложность O(n log n)
  public static double[] medianSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int j = 0;
    double[] result = new double[n - k + 1];
    List<Integer> list = new ArrayList<>();
    // Добавление первых k-1 элементов
    for (int i = 0; i < k - 1; i++)
      list.add(nums[i]);
    // Сортируем, т.к. нам надо отсортированный список для нахождения медианы
    Collections.sort(list);
    for (int i = k - 1; i < n; i++) {
      // Двоичный поиск, если элемент уже присутствует в списке функция ниже возвращает индекс,
      // иначе она возвращает - (ожидаемая позиция +1), да, это отрицательный знак
      int r = Collections.binarySearch(list, nums[i]);
      if (r > -1)
        list.add(r + 1, nums[i]); // добавить рядом с ним
      else list.add(Math.abs(r + 1), nums[i]); // Добавьте его в ожидаемое положение
      // Вставьте в список result медиану согласно значению k
      if (k % 2 == 0) {
        result[i - k + 1] = ((double)list.get((k / 2) - 1) + list.get((k / 2))) / 2.0;
      } else {
        result[i - k + 1] = list.get((k / 2));
      }
      // Когда окно сдвигается на один элемент, мы просто находим его позицию
      // в отсортированном списке и удаляем его
      int l = Collections.binarySearch(list, nums[j]);
      list.remove(l);
      j++;
    }
    return result;
  }
  public static double[] medianSlidingWindow1(int[] nums, int k) {
    List<Double> medians = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    // max куча
    PriorityQueue<Integer> lo = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    // min куча
    PriorityQueue<Integer> hi = new PriorityQueue<>();
    int i = 0; // индекс текущего обрабатываемого входящего элемента
    // инициализировать кучу
    while (i < k) {
      lo.offer(nums[i++]);
    }
    for (int j = 0; j < k / 2; j++) {
      hi.offer(lo.poll());
    }
    while (true) {
      // получить медиану текущего окна
      medians.add(k % 2 == 1 ?
        (double) lo.peek() : ((double) lo.peek() + (double) hi.peek()) * 0.5);
      if (i >= nums.length)
        break; // выходим, если обработаны все элементы
      int outNum = nums[i - k]; // исходящий элемент
      int inNum = nums[i++]; // входящий элемент
      int balance = 0; // balance factor
      // число `outNum` выходит из окна
      balance += (outNum <= lo.peek() ? -1 : 1);
      map.put(outNum, map.getOrDefault(outNum, 0) + 1);
      // число `inNum` входит в окно
      if (!lo.isEmpty() && inNum <= lo.peek()) {
        balance++;
        lo.offer(inNum);
      } else {
        balance--;
        hi.offer(inNum);
      }
      // перебалансировать кучу
      if (balance < 0) { // `lo` нужно больше допустимых элементов
        lo.offer(hi.poll());
        balance++;
      }
      if (balance > 0) { // `hi` требует больше допустимых элементов
        hi.offer(lo.poll());
        balance--;
      }
      // удалить недопустимые числа, которые следует отбросить из вершин кучи
      while (map.getOrDefault(lo.peek(), 0) > 0) {
        map.put(lo.peek(), map.get(lo.peek()) - 1);
        lo.poll();
      }
      while (!hi.isEmpty() && map.getOrDefault(hi.peek(), 0) > 0) {
        map.put(hi.peek(), map.get(hi.peek()) - 1);
        hi.poll();
      }
    }
    double[] result = new double[medians.size()];
    for (int j = 0; j < medians.size(); j++) {
      result[j] = medians.get(j);
    }
    return result;
  }
  /**
   * Using TreeSet. (Here time complexity is most optimized)
   *
   * Very similar to https://leetcode.com/problems/find-median-from-data-stream/
   *
   * Time Complexity: O((N-K)*log K + N*log K) = O(N * log K)
   * Add Elements = O(N*Log K)
   * Remove Elements = O((N-K)*log K) ==> TreeSet.remove() in JAVA is O(log K)
   *
   * Space Complexity: O(K)
   *
   * N = Length of nums array. K = Input k.
   */
    public static double[] medianSlidingWindow2(int[] nums, int k) {
      int n = nums.length;
      double[] result = new double[n - k + 1];
      if (k == 1) return Arrays.stream(nums).asDoubleStream().toArray();
      Comparator<Integer> comparator =
        (a, b) -> (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b));
      TreeSet<Integer> smallNums = new TreeSet<>(comparator.reversed());
      TreeSet<Integer> largeNums = new TreeSet<>(comparator);
      for (int i = 0; i < n; i++) {
        if (i >= k) {
          removeElement(smallNums, largeNums, nums, i - k);
        }
        addElement(smallNums, largeNums, i);
        if (i >= k - 1) {
          result[i - (k - 1)] = getMedian(smallNums, largeNums, nums);
        }
      }
      return result;
    }
    private static void addElement(TreeSet<Integer> smallNums, TreeSet<Integer> largeNums, int i) {
      smallNums.add(i);
      largeNums.add(smallNums.pollFirst());
      if (smallNums.size() < largeNums.size()) {
        smallNums.add(largeNums.pollFirst());
      }
    }
    private static void removeElement(TreeSet<Integer> smallNums, TreeSet<Integer> largeNums,
                                      int[] nums, int i) {
      if (largeNums.contains(i)) {
        largeNums.remove(i);
        if (smallNums.size() == largeNums.size() + 2) {
          largeNums.add(smallNums.pollFirst());
        }
      } else {
        smallNums.remove(i);
        if (smallNums.size() < largeNums.size()) {
          smallNums.add(largeNums.pollFirst());
        }
      }
    }
    private static double getMedian(TreeSet<Integer> smallNums, TreeSet<Integer> largeNums, int[] nums) {
      if (smallNums.size() == largeNums.size()) {
        return ((double) nums[smallNums.first()] + nums[largeNums.first()]) / 2;
      }
      return nums[smallNums.first()];
    }
  // В следующем решении мы используем приоритетную очередь (кучу).
  // Здесь операция удаления в Java не оптимизирована.
  /**
   * Using Priority Queue. (Here time complexity is not optimized)
   *
   * Very similar to https://leetcode.com/problems/find-median-from-data-stream/
   *
   * Time Complexity: O((N-K)*K + N*log K).
   * Add Elements = O(N*Log K)
   * Remove Elements = O((N-K)*K) ==> PQ.remove() in JAVA is O(K)
   *
   * Space Complexity: O(K)
   *
   * N = Length of nums array. K = Input k.
   */
    public static double[] medianSlidingWindow3(int[] nums, int k) {
      if (nums == null || k <= 0) {
        throw new IllegalArgumentException("Input is invalid");
      }
      int len = nums.length;
      double[] result = new double[len - k + 1];
      if (k == 1) {
        for (int i = 0; i < len; i++) {
          result[i] = (double) nums[i];
        }
        return result;
        // return Arrays.stream(nums).asDoubleStream().toArray();
      }
      // MaxHeap
      PriorityQueue<Integer> smallNums = new PriorityQueue<>(Collections.reverseOrder());
      // Min Heap
      PriorityQueue<Integer> largeNums = new PriorityQueue<>();
      for (int i = 0; i < len; i++) {
        if (i >= k) {
          removeElem(smallNums, largeNums, nums[i - k]);
        }
        addElem(smallNums, largeNums, nums[i]);
        if (i >= k - 1) {
          result[i - (k - 1)] = getMed(smallNums, largeNums);
        }
      }
      return result;
    }
    private static void addElem(PriorityQueue<Integer> smallNums, PriorityQueue<Integer> largeNums, int n) {
      smallNums.offer(n);
      largeNums.offer(smallNums.poll());
      if (smallNums.size() < largeNums.size()) {
        smallNums.offer(largeNums.poll());
      }
    }
    private static void removeElem(PriorityQueue<Integer> smallNums, PriorityQueue<Integer> largeNums, int n) {
      if (n >= largeNums.peek()) {
        largeNums.remove(n);
        if (smallNums.size() == largeNums.size() + 2) {
          largeNums.offer(smallNums.poll());
        }
      } else {
        smallNums.remove(n);
        if (smallNums.size() < largeNums.size()) {
          smallNums.offer(largeNums.poll());
        }
      }
    }
    private static double getMed(PriorityQueue<Integer> smallNums, PriorityQueue<Integer> largeNums) {
      if (smallNums.size() == largeNums.size()) {
        return ((double) smallNums.peek() + largeNums.peek()) / 2.0;
      }
      return smallNums.peek();
    }
}
