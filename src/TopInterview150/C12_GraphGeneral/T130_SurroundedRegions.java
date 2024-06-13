package TopInterview150.C12_GraphGeneral;
public class T130_SurroundedRegions {
  public static void main(String[] args) {
    char[][] a = {
       {'X', 'X', 'X', 'X'},
       {'X', 'O', 'O', 'X'},
       {'X', 'X', 'O', 'X'},
       {'X', 'O', 'X', 'X'}};
    solve(a);
  }
  public static void solve(char[][] board) {
    if (board.length == 0)
      return;
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < n; i++) {
      if (board[0][i] == 'O') {
        dfs(board, 0, i);
      }
      if (board[m - 1][i] == 'O') {
        dfs(board, m - 1, i);
      }
    }
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'О') {
        dfs(board, i, 0);
      }
      if (board[i][n - 1] == 'О') {
        dfs(board, i, n - 1);
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O')
          board[i][j] = 'X';
        if (board[i][j] == '*')
          board[i][j] = 'O';
      }
    }
  }
  static void dfs(char[][] board, int y, int x) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') {
      return;
    }
    board[x][y] = '*';
    dfs(board, y, x + 1);
    dfs(board, y, x - 1);
    dfs(board, y + 1, x);
    dfs(board, y - 1, x);
  }
  // Вариант 2
  public static void dfs1(char[][] board, int y, int x) {
    int[] dp = {-1, 0, 1, 0};
    board[y][x] = '*';
    for (int i = 0; i < 4; i++) {
      int nx = x + dp[i];
      int ny = y + dp[(i + 1) % 4];
      if (nx >= 0 && nx < board[0].length && ny >= 0 && ny < board.length && board[ny][nx] == 'O')
        dfs1(board, ny, nx);
    }
  }
}
