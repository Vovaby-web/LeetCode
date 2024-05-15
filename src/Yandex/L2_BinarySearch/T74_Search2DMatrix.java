package Lessons.LeetCode.Yandex.L2_BinarySearch;
public class T74_Search2DMatrix {
  public static void main(String[] args) {
    int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    int target = 11;
    System.out.println(searchMatrix(a, target));
  }
  public static boolean searchMatrix(int[][] matrix, int target) {
    // ������� ������ � ������� �������
    int up = 0;
    int down = matrix.length - 1;
    while (up <= down) {
      // ���� �������� �� ���������
      int midVert = up + (down - up) / 2;
      // ������� ����� � ������ ������� �� �����������
      int left = 0;
      int right = matrix[midVert].length - 1;
      int midGor = left + (right - left) / 2;
      while (left <= right) {
        // ���� �������� �� �����������
        midGor = left + (right - left) / 2;
        // ���� ���� �������� < target, �� �������� ����� �������
        if (matrix[midVert][midGor] < target) {
          left = midGor + 1;
        } else
          // ����� �������� ������ �������
          right = midGor - 1;
        // ���� �� ����� ���� �����, �� �������
        if (matrix[midVert][midGor] == target)
          return true;
      }
      // ���� ��� ������ ��������� � ������ �������, ������ ����� ���������� ������
      // ����, �.�. ���� ������� ����� target ������ ���� ����� � �������
      if (midGor == matrix[midVert].length - 1 && matrix[midVert][midGor] < target) {
        up = midVert + 1;
        // ����� ��� ���� ������ ����
      } else down = midVert - 1;
    }
    return false;
  }
}
