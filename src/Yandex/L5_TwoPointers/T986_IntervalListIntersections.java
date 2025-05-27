package Tasks.LeetCode.Yandex.L5_TwoPointers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class T986_IntervalListIntersections {
  public static void main(String[] args) {
    int[][] firstList = {
       {0, 2},
       {5, 10},
       {13, 23},
       {24, 25}
    };
    int[][] secondList = {
       {1, 5},
       {8, 12},
       {15, 24},
       {25, 26}
    };
    System.out.println(Arrays.deepToString(intervalIntersection(firstList, secondList)));
  }
  public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    List<int[]> result = new ArrayList<>();
    int i = 0, j = 0;
    int n = firstList.length;
    int m = secondList.length;
    while (i < n && j < m) {
      int leftA = firstList[i][0];
      int rightA = firstList[i][1];
      int leftB = secondList[j][0];
      int rightB = secondList[j][1];
      int left = Math.max(leftA, leftB);
      int right = Math.min(rightA, rightB);
      if (left <= right) {
        result.add(new int[]{left, right});
      }
      if (rightA < rightB) {
        i++;
      } else {
        j++;
      }
    }
    return result.toArray(new int[result.size()][]);
  }
}
