// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C6_Intervals;
import java.util.Arrays;
import java.util.Comparator;
public class T452_MinimumNumberofArrowstoBurstBalloons {
  public static void main(String[] args) {
    System.out.println(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
  }
  public static int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));
    int ans = 0;
    long last = Long.MIN_VALUE;
    for (var p : points) {
      int a = p[0];
      int b = p[1];
      if (a > last) {
        ans++;
        last = b;
      }
    }
    return ans;
  }
}
