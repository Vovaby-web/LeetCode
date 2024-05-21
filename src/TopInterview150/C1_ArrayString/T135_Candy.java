// https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T135_Candy {
  public static void main(String[] args) {
    System.out.println(candy(new int[]{3, 2, 1, 1, 2, 3}));
  }
  public static int candy(int[] ratings) {
    int n = ratings.length;
    int up = 0;                 // ���������� ��������������� ���������
    int down = 0;               // ���������� ������������� ���������
    int ans = 1;                // ����� ���������� ��������� ������
    for (int i = 1; i < n; i++) {
      // �������� �� ������� ratings ������� � 1 ������� � ���������� ������� ������� � ����������.
      if (ratings[i - 1] < ratings[i]) {
        up++;
        down = 0;
        ans += up + 1;
      } else if (ratings[i] == ratings[i - 1]) {
        up = 0;
        down = 0;
        ans++;
      } else {
       // ���������� ������, ������� �� �������� ���������� �����
        down++;
        // �������� down ������
        ans += down + (up >= down ? 0 : 1);
        up = 0;
      }
    }
    return ans;
  }
}
