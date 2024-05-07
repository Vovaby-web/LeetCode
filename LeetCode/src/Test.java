// https://leetcode.com/problems/longest-substring-without-repeating-characters/
import java.util.*;
public class Test {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5)));
  }
  public static int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    for (int i = 0; i < n; i++) {
      while (!q.isEmpty() && q.peek()[1] <= i - k) {
        q.poll();
      }
      q.offer(new int[]{nums[i],i});
      if (i>=k-1){
        result[i-(k-1)]=q.peek()[0];
      }

    }
    return result;
  }
}
