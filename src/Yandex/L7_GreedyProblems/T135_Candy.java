package Tasks.LeetCode.Yandex.L7_GreedyProblems;
import java.util.Arrays;
public class T135_Candy {
  public static void main(String[] args) {
    System.out.println(candy2(new int[]{1, 2, 3, 1, 0}));
  }
  public static int candy2(int[] ratings) {
    int n = ratings.length;
    int i = 1;
    int count = 1;
    while (i < n) {
      if (ratings[i] == ratings[i - 1]) {
        count++;
        i++;
        continue;
      }
      int up = 1;
      while (i < n && ratings[i] > ratings[i - 1]) {
        up++;
        count += up;
        i++;
      }
      int down = 1;
      while (i < n && ratings[i] < ratings[i - 1]) {
        count += down;
        down++;
        i++;
      }
      if (down > up)
        count += down - up;
    }
    return count;
  }
  public static int candy1(int[] ratings) {
    int n = ratings.length;
    int[] left = new int[n];
    int[] right = new int[n];
    Arrays.fill(left, 1);
    Arrays.fill(right, 1);
    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1])
        left[i] = left[i - 1] + 1;
    }
    for (int i = n - 2; i >= 0; --i) {
      if (ratings[i] > ratings[i + 1])
        right[i] = right[i + 1] + 1;
    }
    int ans = 0;
    for (int i = 0; i < n; ++i) {
      ans += Math.max(left[i], right[i]);
    }
    return ans;
  }
  public static int candy(int[] ratings) {
    int n = ratings.length;
    int up = 0;
    int down = 0;
    int peak = 0;
    int ans = 1;
    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        up++;
        peak = up + 1;
        down = 0;
        ans += peak;
      } else if (ratings[i] == ratings[i - 1]) {
        up = 0;
        down = 0;
        ans++;
      } else {
        down++;
        ans += down + (peak > down ? 0 : 1);
        up = 0;
      }
    }
    return ans;
  }
}
