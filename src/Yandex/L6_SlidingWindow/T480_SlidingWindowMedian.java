package Tasks.LeetCode.Yandex.L6_SlidingWindow;
import java.util.*;
import java.util.function.Supplier;

public class T480_SlidingWindowMedian {
  public static void main(String[] args) {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    System.out.println(Arrays.toString(medianSlidingWindow2(nums, k))); // Вывод: [1.0, -1.0, -1.0, 3.0, 5.0, 6.0]
    nums = new int[]{1};
    k = 1;
    System.out.println(Arrays.toString(medianSlidingWindow(nums, k))); // Вывод: [2.5]
  }
  // O(n log k)
  public static double[] medianSlidingWindow(int[] nums, int k) {
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();
    Map<Integer, Integer> winOut = new HashMap<>();

    for (int i = 0; i < k; i++) {
      left.offer(nums[i]);
    }
    for (int i = 0; i < k / 2; i++) {
      right.offer(left.poll());
    }
    double[] ans = new double[nums.length - k + 1];
    ans[0] = (k & 1) == 1 ? left.peek() : ((double) left.peek() + right.peek()) / 2.0;
    for (int i = k; i < nums.length; i++) {
      int in = nums[i];
      int out = nums[i - k];
      int bal = (out <= left.peek()) ? -1 : 1;

      if (in <= left.peek()) {
        left.offer(in);
        bal++;
      } else {
        right.offer(in);
        bal--;
      }
      if (bal > 0)
        right.offer(left.poll());
      else if (bal < 0)
        left.offer(right.poll());

      winOut.put(out, winOut.getOrDefault(out, 0) + 1);
      while (!left.isEmpty() && winOut.getOrDefault(left.peek(), 0) > 0) {
        winOut.put(left.peek(), winOut.get(left.poll()) - 1);
      }
      while (!right.isEmpty() && winOut.getOrDefault(right.peek(), 0) > 0) {
        winOut.put(right.peek(), winOut.get(right.poll()) - 1);
      }
      ans[i - k + 1] = (k & 1) == 1 ? left.peek() : ((double) left.peek() + right.peek()) / 2.0;
    }
    return ans;
  }

  // O(n log k)
  public static double[] medianSlidingWindow2(int[] nums, int k) {
    Comparator<Integer> comparator =
       (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
    TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
    TreeSet<Integer> right = new TreeSet<>(comparator);

    Supplier<Double> median = () -> (k % 2 == 0) ?
        ((double) nums[left.first()] + nums[right.first()]) / 2 :
        (double) nums[right.first()];

    Runnable balance = () -> {
      while (left.size() > right.size())
        right.add(left.pollFirst());
    };

    double[] ans = new double[nums.length - k + 1];

    for (int i = 0; i < k; i++)
      left.add(i);
    balance.run();
    ans[0] = median.get();

    for (int i = k, r = 1; i < nums.length; i++, r++) {
      if (!left.remove(i - k))
        right.remove(i - k);
      right.add(i);
      left.add(right.pollFirst());
      balance.run();
      ans[r] = median.get();
    }
    return ans;
  }
}
