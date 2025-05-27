package Tasks.LeetCode.Yandex.L5_TwoPointers;
public class T161_OneEditDistance {
  public static void main(String[] args) {
    System.out.println(isOneEditDistance("ab�", "ab�d"));   // true
    System.out.println(isOneEditDistance("abc", "ab"));   // true
    System.out.println(isOneEditDistance("abac", "aac"));  // true
    System.out.println(isOneEditDistance("abc", "a"));    // false
    System.out.println(isOneEditDistance("abc", "abcd")); // true
    System.out.println(isOneEditDistance("abc", "abd"));  // true
  }
  public static boolean isOneEditDistance(String s, String t) {
    int m = s.length();
    int n = t.length();
    // ���� ������� � ����� ����� ������ 1, �� ��� �� ����� ���� �� ���������� ����� ��������
    if (Math.abs(m - n) > 1)
      return false;
    int i = 0, j = 0;
    boolean flag = false;
    while (i < m && j < n) {
      if (s.charAt(i) != t.charAt(j)) {
        if (flag) // ���� ��� ���� ������� �������, ���������� false
          return false;
        flag = true;
        if (m > n) { // ���� ������ ������ �����, ������� ��������� ������ �� ������� ������
          i++;
        } else if (m < n) {
          j++;
        } else { // ���� ������ ���������� �����, ������� ��� ���������
          i++;
          j++;
        }
      } else {   // ���� ������� ���������, ������� ��� ���������
        i++;
        j++;
      }
    }
    // � ������, ���� ��������� ������� ������� � ������ �����
    if (i < m || j < n) {
     return true;
    }
    return flag;
  }
}
