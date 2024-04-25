package Lessons.LeetCode.Yandex.L5_dfs_bfs;
public class T200_NumberIsland {
  public static void main(String[] args) {
    char[][] a = {
      {'1', '1', '1', '1', '1'},
      {'1', '1', '0', '1', '0'},
      {'1', '1', '0', '0', '0'},
      {'0', '0', '0', '0', '0'}};
    System.out.println(numIslands(a));
  }
  public static int numIslands(char[][] grid) {
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        // ���� ������ �� 1, ����� ��������� �����
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          // ���� ������ ��� ��������� ������, �� ��� ���� ������
          result++;
        }
      }
    }
    return result;
  }
  private static void dfs(char[][] matrix, int i, int j) {
    // �������� ������
    matrix[i][j] = '0';
    // ������� ��������
    int[] dp = {-1, 0, 1, 0};
    // ������� ��� �������� ������
    for (int k = 0; k < 4; k++) {
      // ���������� y
      int y = i + dp[k];
      // ���������� x
      int x = j + dp[(k + 1) % 4];
      // ���� ������ y,x �� ������� �� ������� � = 1, ����� ������� ����
      if (x >= 0 && x < matrix[0].length &&
        y >= 0 && y < matrix.length && matrix[y][x] == '1') {
        // ��������� ��� �� �� �������� ��� ������ y,x
        dfs(matrix, y, x);
      }
    }
  }
}
