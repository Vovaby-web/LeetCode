// https://leetcode.com/problems/course-schedule/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C12_GraphGeneral;
import java.util.*;
public class T207_CourseSchedule {
  public static void main(String[] args) {
    System.out.println(canFinish(4, new int[][]{{1, 0},{2, 1},{3, 0}}));
  }
  public static boolean canFinish(int n, int[][] prerequisites) {
    // �������� ������ ������ ��������� ��� ������������� ���������������� �����.
    Map<Integer,List<Integer>> g = new HashMap<>();
    // �������� ������ � ������ in[n] (���������� ������) � ��������������� ��� ��� �������� ��������� 0.
    // ������ in ����� ����������� ���������� �������� ����� �� ������ ����.
    int[] in = new int[n];
    // �������� ������ ans ������, ����� ��������� �������������� ������� ������.
    List<Integer> ans = new ArrayList<>();
    // ��������� �������� �� prerequisites �������, ������� �������� ���� ������ � ���������
    // ��������������� ����������.
    // ��� ������ ���� [a, b] �������� � ������ ��������� ����� �� b �� a.
    // ��� ��������, ��� ���� b ������ ���� ������� �� ����� a.
    // ��������� in ������� a �� 1, ��� ��� � ���� ���� ��� ���� ������������ �������.
    for (int[] pair : prerequisites) {
      int a = pair[0];
      int b = pair[1];
      g.computeIfAbsent(b,k->new ArrayList<>()).add(a);
      in[a]++;
    }
    // ���������� �������������� ���������� � �������������� ��������� ����:
    // �������� ������ �������, ��������������� q ��� �������� �����, ������� ����� ��������.
    Queue<Integer> queue = new LinkedList<>();
    // ���������� ��� ����� (�� 0 �� n-1) � ��������� in � ������� ����� �� ��������� 0.
    // ��� ����� �� ����� ��������������� ������� � ����� ���� ������ ����������.
    for (int i = 0; i < n; i++) {
      if (in[i] == 0)
        queue.offer(i);
    }
    // ���� ������� �� �����, �������� ���������:
    while (!queue.isEmpty()) {
      // ��������� ������ ������� �� ������� � ��������� ��� � ���������� t.
      int t = queue.poll();
      // �������� t � ans �������, ����� ����������� �������������� �������.
      ans.add(t);
      // ��� ������� ������ x � t ������ ���������:
      // ��������� in[x] �� 1, ��� ��� �� ������� ����������� ������� t.
      // ���� in[x] ���������� ������ 0, ��������� x � �������.
      // ��� ��������, ��� ��� ������� x ���������.
      // ���� ����� if (g.get(t)!=null) {
      if (g.containsKey(t)) {
        for (int x : g.get(t)) {
          in[x]--;
          if (in[x] == 0) {
            queue.offer(x);
          }
        }
      }
    }
    // ���� ��� �����, ��� ��������, ��� ��� ����� ����� ������ ��� �����-����
    // ����������� ������������. ������������ true.
    return ans.size() == n;
  }
}
