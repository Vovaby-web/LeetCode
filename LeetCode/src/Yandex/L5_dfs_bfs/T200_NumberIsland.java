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
        // Если попали на 1, тогда запускаем обход
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          // Если прошли все связанные клетки, то это один остров
          result++;
        }
      }
    }
    return result;
  }
  private static void dfs(char[][] matrix, int i, int j) {
    // Обнуляем клетку
    matrix[i][j] = '0';
    // Матрица смещений
    int[] dp = {-1, 0, 1, 0};
    // Обходим все соседние клетки
    for (int k = 0; k < 4; k++) {
      // Координата y
      int y = i + dp[k];
      // Координата x
      int x = j + dp[(k + 1) % 4];
      // Если клетка y,x не выходит за границы и = 1, тогда заходим туда
      if (x >= 0 && x < matrix[0].length &&
        y >= 0 && y < matrix.length && matrix[y][x] == '1') {
        // Запускаем все те же действия для клетки y,x
        dfs(matrix, y, x);
      }
    }
  }
}
