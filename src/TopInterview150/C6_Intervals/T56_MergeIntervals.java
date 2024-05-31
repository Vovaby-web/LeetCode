// https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C6_Intervals;
import java.util.*;
public class T56_MergeIntervals {
  public static void main(String[] args) {
    System.out.println(
       Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
  }
  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> ans = new ArrayList<>();
    ans.add(intervals[0]);
    for (int i = 1, n = intervals.length; i < n; i++) {
      int s = intervals[i][0];
      int e = intervals[i][1];
      if (ans.get(ans.size() - 1)[1] < s) {
        ans.add(intervals[i]);
      } else {
        ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], e);
      }
    }
    return ans.toArray(new int[ans.size()][]);
  }
}
