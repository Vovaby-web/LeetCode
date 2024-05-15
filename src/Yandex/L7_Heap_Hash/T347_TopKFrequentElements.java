// https://leetcode.com/problems/top-k-frequent-elements/description/
package Yandex.L7_Heap_Hash;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
public class T347_TopKFrequentElements {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(topKFrequent2(new int[]{1, 1, 1, 2, 2, 3}, 2)));
  }
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = Arrays.stream(nums)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
    Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
    return entrySet.stream()
      .sorted((a, b) -> b.getValue() - a.getValue())
      .limit(k)
      .mapToInt(Map.Entry::getKey)
      .toArray();
  }
  public static int[] topKFrequent1(int[] nums, int k) {
    Map<Integer, Long> map = Arrays.stream(nums)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Queue<Map.Entry<Integer, Long>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());
    for (var entry : map.entrySet()) {
      queue.offer(entry);
      if (queue.size() > k) {
        queue.poll();
      }
    }
    return queue.stream()
      .mapToInt(Map.Entry::getKey)
      .toArray();
  }
  public static int[] topKFrequent2(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int v : nums) {
      map.put(v, map.getOrDefault(v, 0) + 1);
    }
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    for (var e : map.entrySet()) {
      queue.offer(new int[] {e.getKey(), e.getValue()});
      if (queue.size() > k) {
        queue.poll();
      }
    }
    int[] result = new int[k];
    for (int i = 0; i < k; ++i) {
      result[i] = queue.poll()[0];
    }
    return result;
  }

}
