package Tasks.LeetCode.Yandex.L7_GreedyProblems;
public class T122_BestTimeToBuyAndSellStock {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
  }
  public static int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1)
      return 0;
    int[] dp = new int[n + 1];
    int diff = -prices[0];
    for (int i = 1; i < n; i++) {
      dp[i + 1] = Math.max(dp[i], diff + prices[i]);
      diff = Math.max(diff, dp[i] - prices[i]);
    }
    return dp[n];
  }
  public static int maxProfit2(int[] prices) {
    int ans = 0;
    int buy = prices[0];
    for (int i = 1; i < prices.length; i++) {
      buy = Math.min(buy, prices[i]);
      if (buy < prices[i]) {
        ans += prices[i] - buy;
        buy = prices[i];
      }
    }
    return ans;
  }
}
