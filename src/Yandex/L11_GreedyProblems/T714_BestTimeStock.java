// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
package Yandex.L11_GreedyProblems;
public class T714_BestTimeStock {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
  }
  // Временная сложность - O(n)
  // Пространственная сложность - O(1);
  public static int maxProfit(int[] prices, int fee) {
    // Инициализируем переменные buy и sell.
    // Переменная buy будет содержать наибольшую прибыль, которую мы можем получить после покупки акции,
    // Другими словами - затраты после приобретения акции
    int buy = -prices[0];
    // Переменная sell будет содержать наибольшую прибыль, которую мы можем получить после продажи акции.
    // Сумма всей прибыли
    int sell = 0;
    // На каждом шаге цикла мы обновляем переменные buy и sell, чтобы учитывать все возможные варианты
    // покупки и продажи акций с учетом текущей цены и комиссии за транзакцию.
    // Таким образом, мы находим максимальную прибыль, которую можно получить при совершении
    // всех возможных транзакций.
    for (int price : prices) {
      // Обновляем прибыль buy после покупки акции, используя формулу Math.max(buy, sell - price).
      buy = Math.max(buy, sell - price);
      // Обновляем прибыль sell после продажи акции, используя формулу Math.max(sell, buy + price - fee).
      sell = Math.max(sell, buy + price - fee);
    }
    // После завершения цикла возвращаем значение sell, так как оно содержит наибольшую прибыль,
    // которую мы можем получить после всех транзакций.
    return sell;
  }
}
