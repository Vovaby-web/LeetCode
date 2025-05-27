package Tasks.LeetCode.Yandex.L6_SlidingWindow;
import java.util.*;
public class T239_SlidingWindowMaximum {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
  }
  public static int[] maxSlidingWindow(int[] nums, int k) {
    Deque<int[]> window = new ArrayDeque<>();
    int[] ans = new int[nums.length - k + 1];
    int left = 0;
    int i = 0;
    for (int right = 0; right < nums.length; right++) {
      while (!window.isEmpty() && window.getLast()[0] < nums[right]) {
        window.pollLast();
      }
      window.add(new int[]{nums[right], right});
      if (right - left + 1 == k) {
        if (!window.isEmpty())
          ans[i++] = window.peek()[0];
        while (!window.isEmpty() && window.peek()[1] <= left) {
          window.poll();
        }
        left++;
      }
    }
    return ans;
  }
  public static int[] maxSlidingWindow1(int[] nums, int k) {
    PriorityQueue<int[]> window = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    List<Integer> ans = new LinkedList<>();
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      window.add(new int[]{nums[right], right});
      if (right - left + 1 == k) {
        assert window.peek() != null;
        ans.add(window.peek()[0]);
        while (!window.isEmpty() && window.peek()[1] <= left) {
          window.poll();
        }
        left++;
      }
    }
    return ans.stream().mapToInt(x -> x).toArray();
  }
}
