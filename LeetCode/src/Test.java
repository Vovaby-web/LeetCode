// https://leetcode.com/problems/longest-substring-without-repeating-characters/
import java.util.*;
public class Test {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1,2,3,4,5,6,7}, 3)));
  }
  public static double[] medianSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    double[] result = new double[n - k + 1];
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      if (i >= k) {
        remove(left, right, nums[i - k]);
      }
      add(left, right, nums[i]);
      if (i >= k - 1) {
        result[i - (k - 1)] = median(left, right);
      }
    }
    return result;
  }
  public static void add(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int x) {
    left.add(x);
    right.add(left.poll());
    if (left.size() < right.size()) {
      left.add(right.poll());
    }
  }
  public static void remove(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int x) {
    if (x >= right.peek()) {
      right.remove(x);
      if (left.size() == right.size() + 2)
        right.add(left.poll());
    } else {
      left.remove(x);
      if (left.size() < right.size())
        left.add(right.poll());
    }
  }
  public static double median(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
    if (left.size() == right.size())
      return (double) (left.peek() + right.peek()) / 2.0;
    else return left.peek();
  }
}
