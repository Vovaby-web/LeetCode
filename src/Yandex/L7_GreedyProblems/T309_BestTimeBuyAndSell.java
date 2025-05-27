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
    // хранит максимальное значение выражения dp[i-1] - prices[i],
    // которое используется для расчета прибыли при покупке акции на предыдущем дне и продаже на текущем дне.
    int diff = -prices[0];
    for (int i = 1; i < n; i++) {
      // Здесь dp[i + 1] представляет собой максимальную прибыль к концу дня i+1,
      // которая может быть либо прибылью, полученной на предыдущем дне dp[i],
      // либо прибылью от продажи акции на текущем дне diff + prices[i].
      dp[i + 1] = Math.max(dp[i], diff + prices[i]);
      // Обновление diff как прибыль на предыдущем дне dp[i-1] и приобретение текущей акции prices[i].
      diff = Math.max(diff, dp[i - 1] - prices[i]);
    }
    return dp[n];
  }
  public static int maxProfit2(int[] prices) {
    // Количество денег до покупки акций (изначально 0).
    int prevProfit = 0;
    // Текущая прибыль от покупок и продаж (изначально 0).
    int currentProfit = 0;
    // Состояние после покупки первой акции.
    // Он инициализируется как отрицательная стоимость первой акции,
    // чтобы смоделировать покупку акции.
    int balancedBuy = prevProfit - prices[0];
    for (int i = 1; i < prices.length; i++) {
      // Вычисляет максимальную прибыль на текущий день, либо оставляя текущую прибыль profit,
      // либо продавая акции, купленные ранее, что соответствует balanced + prices[i].
      int profit = Math.max(currentProfit, balancedBuy + prices[i]);
      // Обновляется, чтобы отразить лучшее состояние после возможной покупки акции
      // по цене prices[i] на текущий день.
      // Это вычисляется как максимальное значение между текущим balanced
      // и состоянием prevProfit - prices[i] (стоимость покупки акции на текущий день).
      balancedBuy = Math.max(balancedBuy, prevProfit - prices[i]);
      // Обновляется значение money до текущей прибыли profit,
      // готовясь к следующему дню.
      prevProfit = currentProfit;
      // Обновляется значение currentProfit до рассчитанной maxProfit для текущего дня.
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