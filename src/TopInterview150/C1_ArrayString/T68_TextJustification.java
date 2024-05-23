// https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
import java.util.*;
public class T68_TextJustification {
  public static void main(String[] args) {
    System.out.println((fullJustify(new String[]{"This", "is", "an",
       "example", "of", "text", "justification", "on"}, 17)));
  }
  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ans = new ArrayList<>();
    for (int i = 0, n = words.length; i < n; ) {
      List<String> temp = new ArrayList<>();
      int count = words[i].length();
      temp.add(words[i++]);
      while (i < n && count + 1 + words[i].length() <= maxWidth) {
        count += 1 + words[i].length();
        temp.add(words[i++]);
      }
      // i == n ������, ��� ��������� ������ ������ ���� (�����+������+�����+����������� �������)
      // "justif on       "
      // t.size() == 1, ���� ���� �����, �� �� ��� ������ � �����, ����� � ����������
      // w = spaceWidth / (t.size() - 1) ����� ������� �� 0
      if (i == n || temp.size() == 1) {
        String left = String.join(" ", temp);
        String right = " ".repeat(maxWidth - left.length());
        ans.add(left + right);
        continue;
      }
      // count - ������� ����� ������ � ������ ������ ������� ����� �������
      // ������ "This is an", count = 10, ������ � t �������� ��� � �������
      // "This","is","an" ����� t = 8
      // ����� ����� �������� = ����� ������ - (������� ����� ������ - ������������ ���� �������)
      // spaceWidth = 16 - (10 - 8) = 8, �.�. ����� ��������� ����� ���� ��������� 8 ��������.
      // ������ �� ���� ������������ ����� ������� - ���������� ���� ����� ������� (t.size() - 1).
      // �� �����, ��� ����������� ����� ����� ������ ��� �������� = 8 (Thisisan), ��� ���� �����
      // ���������� �� � 16, ���������� ��������� 8 ��������, �.�. � ��� 3 ����� � ����� ���� 2 �����.
      // ������ (16-8) / (3-1) = 4, �.�. �� 4 ������� ����� ������� - ���������� - w.
      // � ���� � ��� �� ���� ����� 17 (maxWidth), ������ ����� ����� ������� �������
      // ���������� ��������� �������������� ������ �.�. (17-8) / (3-1) = 4 (������� 1).
      // ��� ������� � ��� ���� ���������� - m
      int spaceWidth = maxWidth - (count - (temp.size() - 1));
      int w = spaceWidth / (temp.size() - 1);
      // ���� ������ ������� �� ���������� �������� ��� ���������� ��������
      int m = spaceWidth % (temp.size() - 1);
      StringBuilder row = new StringBuilder();
      for (int j = 0; j < temp.size(); j++) {
        // ����� ����������� ������ row, ��� ������ ����� �� ������ t ����������� � ������
        // ���������� �������� ����� �������.
        // ��������� ����� ����������� ��� �������������� ��������.
        row.append(temp.get(j));
        if (j < temp.size() - 1)
          row.append(" ".repeat(w + (j < m ? 1 : 0)));
      }
      ans.add(row.toString());
    }
    return ans;
  }
}
