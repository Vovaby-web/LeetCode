package Tasks.LeetCode.Yandex.L12_Dfs_Bfs;
import java.util.*;
public class T200_NumberOfIslands {
  public static void main(String[] args) {
    char[][] grid = {
       {'1', '1', '1', '1', '0'},
       {'1', '1', '0', '1', '0'},
       {'1', '1', '0', '0', '0'},
       {'0', '0', '0', '0', '0'}
    };
    System.out.println(numIslands(grid));
  }
  public static int numIslands(char[][] grid) {
    int[] dp = {-1, 0, 1, 0};
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '0')
          continue;
        count++;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        grid[i][j] = '0';
        while (!q.isEmpty()) {
          int[] xy = q.poll();
          for (int z = 0; z < 4; z++) {
            int y = xy[0] + dp[z % 4];
            int x = xy[1] + dp[(z + 1) % 4];
            if (y >= 0 && y < m && x >= 0 && x < n && grid[y][x] == '1') {
              q.offer(new int[]{y, x});
              grid[y][x] = '0';
            }
          }
        }
      }
    }
    return count;
  }
}
