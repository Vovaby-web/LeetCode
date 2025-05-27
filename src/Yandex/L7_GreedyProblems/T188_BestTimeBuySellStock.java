package Tasks.LeetCode.Yandex.L7_GreedyProblems;
public class T188_BestTimeBuySellStock {
  public static void main(String[] args) {
    System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
  }
  public static int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (n <= 1 || k == 0)
      return 0;
    // Если k >= n/2, то задача сводится к бесконечному количеству транзакций
    if (k >= n / 2) {
      int maxProfit = 0;
      for (int i = 1; i < n; i++) {
        if (prices[i] > prices[i - 1]) {
          maxProfit += prices[i] - prices[i - 1];
        }
      }
      return maxProfit;
    }
    int[][] dp = new int[k + 1][n];
    for (int i = 1; i <= k; i++) {
      int profit = -prices[0];
      for (int j = 1; j < n; j++) {
        dp[i][j] = Math.max(dp[i][j - 1], prices[j] + profit);
        profit = Math.max(profit, dp[i - 1][j] - prices[j]);
      }
    }
    return dp[k][n - 1];
  }
}
