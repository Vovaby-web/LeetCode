// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
package Yandex.L11_GreedyProblems;
public class T714_BestTimeStock {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{1,3,2,8,4,9}, 2));
  }
  // Временная сложность - O(n)
  // Пространственная сложность - O(1);
  public static int maxProfit(int[] prices, int fee) {
    // Инициализируем две переменные: buy и sell.
    // Установим buy отрицательную первую акцию и sell в ноль.
    // Эти переменные будут отслеживать максимальную прибыль каждый день.
    // Цена без акции
    int buy = -prices[0];
    // Цена с акцией
    int sell = 0;
    // Перебирайте цены акций, начиная с первого дня.
    for (int price : prices) {
      // Обновим buy переменную, взяв максимальное ее текущее значение и предыдущее
      // sell значение за вычетом цены акции. Это представляет собой максимальную прибыль
      // после покупки акций.
      buy = Math.max(buy, sell - price);
      // Обновим sell переменную, взяв максимальное значение из ее текущего значения и предыдущего
      // buy значения плюс цена акции за вычетом комиссии за транзакцию.
      // Это представляет собой максимальную прибыль после продажи акций.
      // После перебора всех цен в sell переменной будет сохранена максимальная прибыль.
      sell = Math.max(sell, buy + price - fee);
    }
    return sell;
  }
}
