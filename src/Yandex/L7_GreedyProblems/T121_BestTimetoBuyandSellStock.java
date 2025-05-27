package Tasks.LeetCode.Yandex.L7_GreedyProblems;
public class T121_BestTimetoBuyandSellStock {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
  }
  public static int maxProfit(int[] prices) {
    int min = prices[0];
    int ans = 0;
    for (int i = 1; i < prices.length; i++) {
      ans = Math.max(ans, prices[i] - min);
      min = Math.min(min, prices[i]);
    }
    return ans;
  }
}
