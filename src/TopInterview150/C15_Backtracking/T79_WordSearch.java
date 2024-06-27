// https://leetcode.com/problems/word-search/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C15_Backtracking;
public class T79_WordSearch {
  public static void main(String[] args) {
    System.out.println(exist(new char[][]
       {{'A', 'B', 'C', 'E'},
          {'S', 'F', 'C', 'S'},
          {'A', 'D', 'E', 'E'}}, "ABCCED"));
  }
  public static boolean exist(char[][] board, String word) {
    if (board == null || word == null)
      return false;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, word, 0, i, j))
          return true;
      }
    }
    return false;
  }
  static boolean dfs(char[][] board, String word, int k, int i, int j) {
    if (k == word.length() - 1)
      return board[i][j] == word.charAt(k);
    if (board[i][j] != word.charAt(k))
      return false;
    char c = board[i][j];
    board[i][j] = '0';
    int[] dp = {-1, 0, 1, 0};
    for (int z = 0; z < 4; z++) {
      int y = i + dp[z];
      int x = j + dp[(z + 1) % 4];
      if (x >= 0 && x < board[0].length && y >= 0 && y < board.length &&
         board[y][x] != '0' && dfs(board, word, k + 1, y, x))
        return true;
    }
    board[i][j] = c;
    return false;
  }
}
