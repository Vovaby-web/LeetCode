// https://leetcode.com/problems/valid-anagram/
package Yandex.L3_HashTable;
import java.util.Arrays;
public class T242_ValidAnagram {
  public static void main(String[] args) {
    System.out.println(isAnagram("ana", "aan"));
  }
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] sc = s.toCharArray();
    Arrays.sort(sc);
    char[] tc = t.toCharArray();
    Arrays.sort(tc);
    return String.valueOf(sc)
      .equals(String.valueOf(tc));
  }
/*  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    // 26 �������� � ���������� ��������
    int[] str = new int[26];
    for (int i = 0; i < s.length(); i++) {
      // �.�. ��� ������� a = 97, �� ��� ��������� a �� ������� ����� �� 0 �� 25
      // ���������� � ���� ������� +1
      str[s.charAt(i) - 'a']++;
      // ���������� �� ���� ������� -1
      str[t.charAt(i) - 'a']--;
    }
    // ��������� ��� �������
    for (int i = 0; i < 26; ++i) {
      // ���� ���� �� ������� ������, ������ ���� ������������
      if (str[i] != 0) {
        return false;
      }
    }
    return true;
  }*/
}
