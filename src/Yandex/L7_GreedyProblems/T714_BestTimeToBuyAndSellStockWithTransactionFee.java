package Tasks.LeetCode.Yandex.L7_GreedyProblems;
public class T714_BestTimeToBuyAndSellStockWithTransactionFee {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2)); // 8
  }
  public static int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    if (n <= 1)
      return 0;
    int[] dp = new int[n + 1];
    int diff = -prices[0];
    for (int i = 1; i < n; i++) {
      dp[i + 1] = Math.max(dp[i], diff + prices[i] - fee);
      diff = Math.max(diff, dp[i - 1] - prices[i]);
    }
    return dp[n];
  }
}
