// https://leetcode.com/problems/partition-labels/description/
package Yandex.L8_TwoPointers;
import java.util.*;
public class T763_PartitionLabels {
  public static void main(String[] args) {
    System.out.println(partitionLabels("abcabcde"));
  }
  public static List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    int n = s.length();
    for (int i = 0; i < n; ++i) {
      // ������� ���� ����� ������� ��������� ������� ��� ��� ���������
      last[s.charAt(i) - 'a'] = i;
    }
    List<Integer> result = new ArrayList<>();
    int max = 0;
    int left = 0;
    for (int i = 0; i < n; i++) {
      // max - ��������� ������� ��� ������������ ��������
      // last[s.charAt(i) - 'a'] - ��� ��������� ������� �������� �������
      max = Math.max(max, last[s.charAt(i) - 'a']);
      // ���� ��������� ������� ���� ������������ �������� ��������� � ������� ��������
      // ������ ����� ������� ������ �� �����������
      if (max == i) {
        // ������������ �� ����������
        result.add(i - left + 1);
        // �������� ������ ��������� �����
        left = i + 1;
      }
    }
    return result;
  }
}
