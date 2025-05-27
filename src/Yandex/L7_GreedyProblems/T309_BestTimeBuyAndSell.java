package Tasks.LeetCode.Yandex.L7_GreedyProblems;
public class T309_BestTimeBuyAndSell {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{1, 2, 3, 4, 0, 2}));
  }
  public static int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1)
      return 0;
    int[] dp = new int[n + 1];
    // ������ ������������ �������� ��������� dp[i-1] - prices[i],
    // ������� ������������ ��� ������� ������� ��� ������� ����� �� ���������� ��� � ������� �� ������� ���.
    int diff = -prices[0];
    for (int i = 1; i < n; i++) {
      // ����� dp[i + 1] ������������ ����� ������������ ������� � ����� ��� i+1,
      // ������� ����� ���� ���� ��������, ���������� �� ���������� ��� dp[i],
      // ���� �������� �� ������� ����� �� ������� ��� diff + prices[i].
      dp[i + 1] = Math.max(dp[i], diff + prices[i]);
      // ���������� diff ��� ������� �� ���������� ��� dp[i-1] � ������������ ������� ����� prices[i].
      diff = Math.max(diff, dp[i - 1] - prices[i]);
    }
    return dp[n];
  }
  public static int maxProfit2(int[] prices) {
    // ���������� ����� �� ������� ����� (���������� 0).
    int prevProfit = 0;
    // ������� ������� �� ������� � ������ (���������� 0).
    int currentProfit = 0;
    // ��������� ����� ������� ������ �����.
    // �� ���������������� ��� ������������� ��������� ������ �����,
    // ����� ������������� ������� �����.
    int balancedBuy = prevProfit - prices[0];
    for (int i = 1; i < prices.length; i++) {
      // ��������� ������������ ������� �� ������� ����, ���� �������� ������� ������� profit,
      // ���� �������� �����, ��������� �����, ��� ������������� balanced + prices[i].
      int profit = Math.max(currentProfit, balancedBuy + prices[i]);
      // �����������, ����� �������� ������ ��������� ����� ��������� ������� �����
      // �� ���� prices[i] �� ������� ����.
      // ��� ����������� ��� ������������ �������� ����� ������� balanced
      // � ���������� prevProfit - prices[i] (��������� ������� ����� �� ������� ����).
      balancedBuy = Math.max(balancedBuy, prevProfit - prices[i]);
      // ����������� �������� money �� ������� ������� profit,
      // �������� � ���������� ���.
      prevProfit = currentProfit;
      // ����������� �������� currentProfit �� ������������ maxProfit ��� �������� ���.
      currentProfit = profit;
    }
    return currentProfit;
  }
}
/*
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
 */