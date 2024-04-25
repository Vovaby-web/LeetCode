// https://leetcode.com/problems/single-number/description/
package Lessons.LeetCode.Yandex.L3_HashTable;
public class T136_OneNumber {
  public static void main(String[] args) {
    System.out.println(singleNumber(new int[]{4, 5, 4}));
  }
  public static int singleNumber(int[] nums) {
    // ���������� ��������� �������� �� ����� ����� �������� �����
    int result = 0;
    for (int i : nums) {
      // �������� XOR (��� ����������� ���) ��������� ��������� �������� ��� ����� ��������.
      // � ������ ������, ����� �� ��������� XOR � ���� ������, ���� ���� �� ���������������
      // �������� ����������, ��������� ����� 0, � ���� ������ - �� 1.
      result ^= i;
    }
    return result;
  }
}
