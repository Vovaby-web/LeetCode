import java.util.*;
public class Test {
  public static void main(String[] args) {
    System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
  }
  public static List<String> summaryRanges(int[] nums) {
    List<String> ans = new ArrayList<>();
    for (int i = 0, j, n = nums.length; i < n; i = j + 1) {
      j = i;
      while (j+1 < n && nums[j + 1] == nums[j] + 1) {
        j++;
      }
      ans.add(print(nums, i, j));
    }
    return ans;
  }
  private static String print(int[] a, int i, int j) {
    return i == j ? String.valueOf(a[i]) : String.format("%d->%d", a[i], a[j]);
  }
}
