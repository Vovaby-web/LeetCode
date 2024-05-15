// https://leetcode.com/problems/sliding-window-maximum/description/
package Yandex.L9_SlidingWindow;
import java.util.*;
public class T239_SlidingWindowMax {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(maxSlidingWindow1(new int[]{2,3,-1,4,5}, 3)));
  }
  // Сложность - O(N\log{k})
  // Память - O(k)
  public static int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (!q.isEmpty() && i - (k - 1) > q.peekFirst()) {
        q.pollFirst();
      }
      while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
        q.pollLast();
      }
      q.offer(i);
      if (i >= k - 1) {
        result[i - (k - 1)] = nums[q.peekFirst()];
      }
    }
    return result;
  }
  public static int[] maxSlidingWindow1(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    for (int i = 0; i < n; i++) {
      while (!queue.isEmpty() && queue.peek()[1] <= i - k) {
        queue.poll();
      }
      queue.offer(new int[]{nums[i], i});
      if (i >= k - 1) {
        result[i - (k - 1)] = queue.peek()[0];
      }
    }
    return result;
  }
}
