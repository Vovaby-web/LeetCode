// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
package Yandex.L11_GreedyProblems;
public class T122_BestTimeStockII {
 public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
  }
  public static int maxProfit(int[] prices) {
    int min=Integer.MAX_VALUE;
    int max=0;
    int result=0;
    for (int i=0;i<prices.length;i++){
      if (min>prices[i]){
        min=prices[i];
        max=0;
      }
      if (max<prices[i])
        max=prices[i];
      if (max>min){
        result+=max-min;
        min=prices[i];
        max=0;
      }
    }
    return result;
  }
}
