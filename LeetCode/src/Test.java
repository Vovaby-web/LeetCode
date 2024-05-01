import java.util.*;
public class Test {
  public static void main(String[] args) {
    int[][] a = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    Arrays.sort(a, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        int result = o1[0] - o2[0];
        if (result == 0)
          result = o1[1] - o2[1];
        return result;
      }
    });
    List<int[]> list = new ArrayList<>();
    int start = 0;
    int end = 0;
    for (int i = 0; i < a.length; i++) {
      if (i > 0) {
        if (end < a[i][0]) {
          start = a[i][0];
          end = a[i][1];
          list.add(new int[]{start, end});
        } else if (end < a[i][1]) {
          list.add(new int[]{start, a[i][1]});
          start = a[i][0];
          end = a[i][1];
        } else {
          end = a[i][1];
        }
      } else {
        start = a[i][0];
        end = a[i][1];
      }
    }
    for (int[] x : list)
      System.out.print(Arrays.toString(x) + " ");
  }
}
