package Tasks.LeetCode.Yandex.L3_HashTable;
import java.util.*;
public class T347_TopKFrequentElements {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
  }
  // ’удший вариант (n log n)
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
    }
    int[] ans = new int[k];
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
       (a, b) -> b.getValue() - a.getValue());
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      pq.offer(entry);
    }
    for (int i = 0; i < k; i++) {
      ans[i] = pq.poll().getKey();
    }
    return ans;
  }
}
