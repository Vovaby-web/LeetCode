// https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C4_Matrix;
import java.util.Arrays;
public class T289_GameofLife {
  public static void main(String[] args) {
    int[][] matrix = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
    gameOfLife(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }
  public static void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    int[] dp = {-1, -1, 0, 1, 1, -1, 1, 0};
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
          int x = i + dp[k];
          int y = j + dp[(k + 1) % 8];
          if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] > 0)
            count++;
        }
        if (board[i][j] == 1 && (count < 2 || count > 3)) {
          board[i][j] = 2;
        }
        if (board[i][j] == 0 && count == 3) {
          board[i][j] = -1;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 2) {
          board[i][j] = 0;
        } else if (board[i][j] == -1) {
          board[i][j] = 1;
        }
      }
    }
  }
}

