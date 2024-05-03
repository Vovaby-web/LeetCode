// https://leetcode.com/problems/sliding-window-median/description/
package Yandex.L9_SlidingWindow.T480;
import java.util.*;
public class T480_SlidingWindowMedian {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
  }
  public static double[] medianSlidingWindow(int[] nums, int k) {
    List<Double> resList = new ArrayList<>();
    int n = nums.length;
    int i = 0;
    int j = k - 1;
    List<Integer> temp = new ArrayList<>();
    for (int x = 0; x < k - 1; x++) {
      temp.add(nums[x]);
    }
    // Этот временный вектор сортируется для представления начального скользящего окна
    Collections.sort(temp);
    while (j < n) {
      int num = nums[j];
      int insertIdx = Collections.binarySearch(temp, num);
      if (insertIdx < 0) {
        insertIdx = -insertIdx - 1;
      }
      temp.add(insertIdx, num);
      if (k % 2 == 1) {
        double median = (double) temp.get(k / 2);
        resList.add(median);
      } else {
        int idx = k / 2;
        double median1 = (double) temp.get(idx);
        double median2 = (double) temp.get(idx - 1);
        resList.add((median1 + median2) / 2);
      }
      int removeIdx = Collections.binarySearch(temp, nums[i]);
      if (removeIdx < 0) {
        removeIdx = -removeIdx - 1;
      }
      temp.remove(removeIdx);
      i++;
      j++;
    }
    return resList.stream().mapToDouble(Double::doubleValue).toArray();
  }
}
