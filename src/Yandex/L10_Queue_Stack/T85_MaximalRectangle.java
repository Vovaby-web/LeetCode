package Tasks.LeetCode.Yandex.L10_Queue_Stack;
import java.util.*;
public class T85_MaximalRectangle {
  public static void main(String[] args) {
    char[][] matrix = {
       {'1', '1', '1', '0', '1'},
       {'1', '0', '1', '1', '1'},
       {'1', '1', '1', '1', '1'},
       {'1', '0', '0', '1', '0'}
    };
    T85_MaximalRectangle o = new T85_MaximalRectangle();
    System.out.println(o.maximalRectangle(matrix)); // Output: 6
  }
  public int maximalRectangle(char[][] matrix) {
    int n = matrix[0].length;
    int m = matrix.length;
    int[] heights = new int[n];
    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
      }
      ans = Math.max(ans, largestRectangleArea(heights));
    }
    return ans;
  }
  private int largestRectangleArea(int[] heights) {
    int res = 0;
    int n = heights.length;
    Deque<Integer> dq = new ArrayDeque<>();
    int[] left = new int[n];
    int[] right = new int[n];
    Arrays.fill(right, n);
    for (int i = 0; i < n; i++) {
      while (!dq.isEmpty() && heights[dq.peek()] >= heights[i]) {
        right[dq.pop()] = i;
      }
      left[i] = dq.isEmpty() ? -1 : dq.peek();
      dq.push(i);
    }
    for (int i = 0; i < n; ++i) {
      res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
    }
    return res;
  }
}
