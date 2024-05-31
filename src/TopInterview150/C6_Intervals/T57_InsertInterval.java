// https://leetcode.com/problems/insert-interval/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C6_Intervals;
import java.util.*;
public class T57_InsertInterval {
  public static void main(String[] args) {
    System.out.println(
       Arrays.deepToString(insert(
          new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
  }
  public static int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> ans = new ArrayList<>();
    int start = newInterval[0];
    int end = newInterval[1];
    for (int i = 0, n = intervals.length; i < n; i++) {
      int s = intervals[i][0];
      int e = intervals[i][1];
      if (s > end)
        ans.add(new int[]{start, end});
      if (s > end || e < start || (s <= start && e >= end)) {
        ans.add(new int[]{s, e});
      } else if (s >= start && e >= end) {
        end=e;
      } else if (s < start && e < end) {
        start = s;
      }
    }
    return ans.toArray(new int[ans.size()][]);
  }
  public static int[][] insert1(int[][] intervals, int[] newInterval) {
    List<int[]> ans = new ArrayList<>();
    int start = newInterval[0];
    int end = newInterval[1];
    boolean stack = false;
    for (int[] x : intervals) {
      int s = x[0];
      int e = x[1];
      if (end < s) {
        if (!stack) {
          ans.add(new int[]{start, end});
          stack = true;
        }
        ans.add(x);
      } else if (e < start) {
        ans.add(x);
      } else {
        start = Math.min(start, s);
        end = Math.max(end, e);
      }
    }
    if (!stack) {
      ans.add(new int[]{start, end});
    }
    return ans.toArray(new int[ans.size()][]);
  }
}
