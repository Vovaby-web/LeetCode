// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
package TopInterview150.C1_ArrayString;
public class T122_BestTimeStockII {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
  }
  public static int maxProfit(int[] prices) {
    int buy = -prices[0];
    int sell = 0;
    for (int price : prices) {
      buy = Math.max(buy, sell - price);
      sell = Math.max(sell, buy + price);
    }
    return sell;
  }
  public static int maxProfit1(int[] prices) {
    int n = prices.length;
    int ans = 0;
    int a = prices[0];
    for (int i = 1; i < n; i++) {
      if (a < prices[i])
        ans += prices[i] - a;
      a = prices[i];
    }
    return ans;
  }
}
