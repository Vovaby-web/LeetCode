package Tasks.LeetCode.Yandex.L1_Array;
import java.util.*;
public class T57_InsertInterval {
  public static void main(String[] args) {
    int[][] a = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    int[] a1 = {4, 8};
    System.out.println(Arrays.deepToString(insert(a, a1)));
  }
  public static int[][] insert(int[][] a, int[] b) {
    ArrayList<int[]> ans = new ArrayList<>();
    int n = a.length;
    int i = 0;
    while (i < n && b[0]>a[i][1]) {
      ans.add(a[i]);
      i++;
    }
    while (i < n && b[1] >= a[i][0] ) {
      b[0] = Math.min(b[0], a[i][0]);
      b[1] = Math.max(b[1], a[i][1]);
      i++;
    }
    ans.add(b);
    while (i < n) {
      ans.add(a[i]);
      i++;
    }
    return ans.toArray(new int[ans.size()][]);
  }
  public static int[][] insert1(int[][] intervals, int[] newInterval) {
    List<int[]> ans = new ArrayList<>();
    int nLeft = newInterval[0];
    int nRight = newInterval[1];
    boolean insert = false;
    for (int[] interval : intervals) {
      int left = interval[0];
      int right = interval[1];
      if (nRight < left) {
        if (!insert) {
          ans.add(new int[]{nLeft, nRight});
          insert = true;
        }
        ans.add(interval);
      } else if (nLeft > right) {
        ans.add(interval);
      } else {
        nLeft = Math.min(nLeft, left);
        nRight = Math.max(nRight, right);
      }
    }
    if (!insert) {
      ans.add(new int[]{nLeft, nRight});
    }
    return ans.toArray(new int[ans.size()][]);
  }
}
