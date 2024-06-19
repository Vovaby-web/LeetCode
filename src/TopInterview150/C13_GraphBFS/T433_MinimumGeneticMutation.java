// https://leetcode.com/problems/minimum-genetic-mutation/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C13_GraphBFS;
import java.util.*;
public class T433_MinimumGeneticMutation {
  public static void main(String[] args) {
    System.out.println(minMutation("AACCGGTT", "AAACGGTA",
       new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
  }
  // �� ����� ������ ������ ������ ��� ���� � ����� ��������� ��, ����
  // 1. ���������� ������ ���� ������
  // 2. ������� ���� �������� � `bank`
  // �������� ������ � ���, ����� ����� ���������� ���� �� ��������� ����� �� �������� �����
  // ��� ������������� BFS
  public static int minMutation(String start, String end, String[] bank) {
      // ������� ��� �������� ������ ������ ���� (����)
      Queue<String> q = new LinkedList<>();
      // ���, ������� ����� ���������, ���� �� �������� ����
      HashSet<String> vis = new HashSet<String>();
      // ������������ ���� � ������
      List<String> banks = Arrays.asList(bank);
      // ����������
      int steps = 0;
      // �� �������� � ������ ������ "start" � �������� ��������� �����
      // �������� ���� � �������
      q.add(start);
      // � �������� ��� ��� ����������
      vis.add(start);
      // BFS
      while (!q.isEmpty()) {
        // �������� � �����, ������ ��� ������ q ��������,
        // ��� �������� � ������������� ������, ���� �� ��������� �������� �� 0
        // �������������, �� ������ ���������� ����� ���������� ��� q.size() ����� ������ for
        // �.�.
        // int n = q.size();
        // for (int i = 0; i < n; i++) {
        for (int i = q.size(); i > 0; i--) {
          // �������� ������ (����) ���� �� �������
          String s = q.poll();
          // ���� ��� ���� �����, ��� � "end", �� �� ����� �����
          if (s.equals(end))
            return steps;
          // � ��������� ������, ���� ������ ������ ������ ������ 8 ��������
          // �� ����� �������� ������ ������ �� �A�, �C�, �G� � �T�
          char[] ca = s.toCharArray();
          for (int j = 0; j < 8; j++) {
            // s[j] ����� �������� �����, �������������, ��������� ����� �������� ������
            char oc = ca[j];
            // ��������� ACGT
            // ������������� �� ������ ������������ `for (char c : "ACGT") { ...}
            for (int k = 0; k < 4; k++) {
              // �������� j-� ������ � s �� k-� ������ � ACGT
              ca[j] = "ACGT".charAt(k);
              // �� ����� ������� ���������� ����, ���� ��������� ���� ��� �� ��� �������
              // � ��������� ���� �������� � "bank"
              String t = new String(ca);
              if (!vis.contains(t) && banks.contains(t)) {
                // �������� ��������� ���� � �������
                q.add(t);
                // ������ ��� ����������
                vis.add(t);
              }
            }
            // ��� �� �� �������� ���������, �� ���������� ��� �������
            ca[j] = oc;
          }
        }
        // ����������� ���������� �����
        steps += 1;
      }
      // ���������� ������� `end`, ������� ����� -1
      return -1;
    }
  }
