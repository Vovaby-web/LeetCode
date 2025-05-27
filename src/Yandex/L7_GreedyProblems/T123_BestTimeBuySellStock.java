package Tasks.LeetCode.Yandex.L7_GreedyProblems;

public class T123_BestTimeBuySellStock {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
  }
  public static int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1)
      return 0;
    // dp1[i] хранит максимальную прибыль, которую можно получить, совершив одну транзакцию до дн€ i включительно.
    int[] dp1 = new int[n];
    // dp2[i] хранит максимальную прибыль, которую можно получить, совершив одну транзакцию начина€ с дн€ i и позже.
    int[] dp2 = new int[n];
    // ѕроходим по массиву цен и дл€ каждого дн€ вычисл€ем максимальную прибыль при одной транзакции.
    // minProfit отслеживает минимальную цену на текущий момент.
    int minProfit = prices[0];
    for (int i = 1; i < n; i++) {
      dp1[i] = Math.max(dp1[i - 1], prices[i] - minProfit);
      minProfit = Math.min(minProfit, prices[i]);
    }
    // ѕроходим по массиву цен в обратном пор€дке и дл€ каждого дн€ вычисл€ем максимальную прибыль
    // при одной транзакции, начина€ с текущего дн€.
    // maxProfit отслеживает максимальную цену на текущий момент.
    int maxProfit = prices[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      dp2[i] = Math.max(dp2[i + 1], maxProfit - prices[i]);
      maxProfit = Math.max(maxProfit, prices[i]);
    }
    // ѕроходим по массиву и дл€ каждого дн€ находим максимальную сумму прибыли от первой и второй транзакций.
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(maxProfit, dp1[i] + dp2[i]);
    }
    return ans;
  }
}
