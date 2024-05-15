// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
package Yandex.L11_GreedyProblems;
public class T714_BestTimeStock {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
  }
  // ��������� ��������� - O(n)
  // ���������������� ��������� - O(1);
  public static int maxProfit(int[] prices, int fee) {
    // �������������� ���������� buy � sell.
    // ���������� buy ����� ��������� ���������� �������, ������� �� ����� �������� ����� ������� �����,
    // ������� ������� - ������� ����� ������������ �����
    int buy = -prices[0];
    // ���������� sell ����� ��������� ���������� �������, ������� �� ����� �������� ����� ������� �����.
    // ����� ���� �������
    int sell = 0;
    // �� ������ ���� ����� �� ��������� ���������� buy � sell, ����� ��������� ��� ��������� ��������
    // ������� � ������� ����� � ������ ������� ���� � �������� �� ����������.
    // ����� �������, �� ������� ������������ �������, ������� ����� �������� ��� ����������
    // ���� ��������� ����������.
    for (int price : prices) {
      // ��������� ������� buy ����� ������� �����, ��������� ������� Math.max(buy, sell - price).
      buy = Math.max(buy, sell - price);
      // ��������� ������� sell ����� ������� �����, ��������� ������� Math.max(sell, buy + price - fee).
      sell = Math.max(sell, buy + price - fee);
    }
    // ����� ���������� ����� ���������� �������� sell, ��� ��� ��� �������� ���������� �������,
    // ������� �� ����� �������� ����� ���� ����������.
    return sell;
  }
}
