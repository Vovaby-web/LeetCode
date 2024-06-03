// https://leetcode.com/problems/insert-interval/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C6_Intervals;
import java.util.*;
public class T57_InsertInterval {
  public static void main(String[] args) {
    System.out.println(
       Arrays.deepToString(insert(
          new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8})));
  }
  public static int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> ans = new ArrayList<>();
    int start = newInterval[0];
    int end = newInterval[1];
    int n = intervals.length;
    boolean stack=true;
    for (int i = 0; i < n; i++) {
      int s = intervals[i][0];
      int e = intervals[i][1];
      if (s > end){
        if (stack){
          ans.add(new int[]{start, end});
          stack=false;
        }
        ans.add(new int[]{s, e});
      } else if (e < start) {
        ans.add(new int[]{s, e});
      } else  {
        start=Math.min(start,s);
        end=Math.max(end,e);
      }
    }
    if (stack) ans.add(new int[]{start, end});
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
