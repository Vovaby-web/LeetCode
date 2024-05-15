// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
package Yandex.L11_GreedyProblems;
public class T309_BestTimeStock {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
  }
  // ��������� ��������� - O(n)
  // ���������������� ��������� - O(1);
  public static int maxProfit(int[] prices) {
    // �������������� ���������� buy � sell.
    // ���������� buy ����� ��������� ���������� �������, ������� �� ����� �������� ����� ������� �����,
    // ������� ������� - ������� ����� ������������ �����
    int buy = -prices[0];
    int prev = 0;
    // ���������� sell ����� ��������� ���������� �������, ������� �� ����� �������� ����� ������� �����.
    // ����� ���� �������
    int sell = 0;
    // �� ������ ���� ����� �� ��������� ���������� buy � sell, ����� ��������� ��� ��������� ��������
    // ������� � ������� ����� � ������ ������� ���� � �������� �� ����������.
    // ����� �������, �� ������� ������������ �������, ������� ����� �������� ��� ����������
    // ���� ��������� ����������.
    for (int price : prices) {
      // ��������� ������� buy ����� ������� �����, ��������� ������� Math.max(buy, sell - price).
      buy = Math.max(buy, prev - price);
      // ��������� ������� sell ����� ������� �����, ��������� ������� Math.max(sell, buy + price - fee).
      prev = sell;
      sell = Math.max(sell, buy + price);
    }
    // ����� ���������� ����� ���������� �������� sell, ��� ��� ��� �������� ���������� �������,
    // ������� �� ����� �������� ����� ���� ����������.
    return sell;
  }
}
