// https://leetcode.com/problems/merge-intervals/
package Yandex.L6_Sort;
import java.util.*;
public class T56_MergeIntervals {
  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8,10},{15,18}})));
  }
  public static int[][] merge(int[][] intervals) {
    // Сортировка массива по первому столбцу
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    int start = intervals[0][0];
    int end = intervals[0][1];
    List<int[]> list = new ArrayList<>();
    for (int i = 1; i < intervals.length; i++) {
      int s = intervals[i][0];
      int e = intervals[i][1];
      // Если текущий старт больше предыдущего end
      if (s > end) {
        list.add(new int[] {start, end});
        start = s;
        end = e;
      } else {
        end = Math.max(end, e);
      }
    }
    list.add(new int[] {start, end});
    return list.toArray(new int[list.size()][]);
  }
}
