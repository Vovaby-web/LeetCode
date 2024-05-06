// https://leetcode.com/problems/sliding-window-maximum/description/
package Yandex.L9_SlidingWindow;
import java.util.*;
public class T239_SlidingWindowMax {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(maxSlidingWindow(new int[]{4, 3, 2, -1, -3, 5, 3, 6, 7}, 3)));
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
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    int n = nums.length;
    for (int i = 0; i < k - 1; i++) {
      q.offer(new int[]{nums[i], i});
    }
    int[] result = new int[n - k + 1];
    for (int i = k - 1, j = 0; i < n; i++) {
      q.offer(new int[]{nums[i], i});
      while (q.peek()[1] <= i - k) {
        q.poll();
      }
      result[j++] = q.peek()[0];
    }
    return result;
  }

  // Самый быстрый способ O(n)
  public static int[] maxSlidingWindow3(int[] nums, int k) {
    if (nums.length == 0 || k == 0) {
      return new int[0];
    }
    int n = nums.length;
    int[] result = new int[n - k + 1];
    int[] left = new int[n];
    int[] right = new int[n];
    left[0] = nums[0];
    right[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) {
      if (i % k == 0) {
        left[i] = nums[i];
      } else left[i] = Math.max(left[i - 1], nums[i]);
      int j = n - i - 1;
      if (j % k == (k - 1)) {
        right[j] = nums[j];
      } else right[j] = Math.max(right[j + 1], nums[j]);
    }
    for (int i = 0, j = i + k - 1; j < n; i++, j++) {
      result[i] = Math.max(right[i], left[j]);
    }
    return result;
  }
}
