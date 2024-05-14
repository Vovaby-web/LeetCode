package Yandex.L11_GreedyProblems;
public class T121_BestTimeStock {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
  }
  public static int maxProfit(int[] prices) {
    int buy = prices[0];
    int sell = 0;
    for (int price : prices) {
      buy = Math.min(buy, price);
      sell = Math.max(sell, price - buy);
    }
    return sell;
  }
}
