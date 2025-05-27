// У нас есть два интервьювера. У каждого есть окна свободного времени для проведения собеседования.
// Определить промежуток времени, в который оба свободны и который больше по времени, чем - d
// d=8
// window_a = [[10,50], [60,120], [120,150]]
// window_b = [[5,10], [60,70], [100,120]]
// Ответ - [60,68]
package Tasks.LeetCode.Yandex.L13_Other;
import java.util.Arrays;
public class E1_IntersectingInterval {
  public static void main(String[] args) {
    int[][] a = {{10, 50}, {60, 120}, {120, 150}};
    int[][] b = {{5, 10}, {60, 70}, {100, 120}};
    int d = 8;
    System.out.println(Arrays.toString(intervals(a, b, d)));
  }
  public static int[] intervals(int[][] a, int[][] b, int d) {
    int n = a.length;
    int m = b.length;
    int i = 0;
    int j = 0;
    while (i < n && j < m) {
      int min = Math.max(a[i][0], b[j][0]);
      int max = Math.min(a[i][1], b[j][1]);
      if (max - min >= d)
        return new int[]{min, min + d};
      if (a[i][1] < b[j][1])
        i++;
      else j++;
    }
    return new int[]{};
  }
}
