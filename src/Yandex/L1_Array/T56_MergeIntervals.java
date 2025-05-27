package Tasks.LeetCode.Yandex.L1_Array;
import java.util.Arrays;
public class T56_MergeIntervals {
  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
  }
  public static int[][] merge(int[][] arr) {
    Arrays.sort(arr, (a, b) -> a[0] - b[0]);
    int j = 0;
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      int min = Math.max(arr[j][0], arr[i][0]);
      int max = Math.min(arr[j][1], arr[i][1]);
      int len = max - min;
      if (len >= 0) {
        arr[j][1] = Math.max(arr[i][1], arr[j][1]);
      } else {
        j++;
        arr[j][0] = arr[i][0];
        arr[j][1] = arr[i][1];
      }
    }
    return Arrays.copyOfRange(arr, 0, j + 1);
  }
}
