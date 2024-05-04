// https://leetcode.com/problems/longest-repeating-character-replacement/description/
package Yandex.L9_SlidingWindow.T480;
public class T424_CharReplacement {
  public static void main(String[] args) {
    System.out.println(characterReplacement("AABACCA", 1));
  }
  // ������� ����������� ����
  // ��������� - O(n) �.�. �� �������� ���� ���
  // ������ - �(1) ������ ��� �� ������������ ���������� ������������,
  // ������� � �������� �� 26 ��������, �������
  // ���������� � �� ������� �� ������� ������ �s�.
  public static int characterReplacement(String s, int k) {
    int[] a = new int[26];
    int n = s.length();
    // ����� ��������� ����������� ���� � l � r � ��� ������ ���������
    int l = 0;
    int max = 0;
    for (int r = 0; r < n; r++) {
      int cr = s.charAt(r) - 'A';
      int cl = s.charAt(l) - 'A';
      // ������� ���������� ������� ������� � ������ s
      a[cr]++;
      // ��������� ������ � ������������ ����������� ���������
      max = Math.max(max, a[cr]);
      // ������ �� ���������, ������������� �� ���� ������� ���� ��� ���
      while (r - l + 1 - max > k) {
        // �������� ���� ������, ��� �����:
        // ��������� ������� �������, ������� ��� � l, ������ ��� ��� ������ ��� � ����
        a[cl]--;
        // �������� �������
        l++;
      }
    }
    return n - l;
  }
}
