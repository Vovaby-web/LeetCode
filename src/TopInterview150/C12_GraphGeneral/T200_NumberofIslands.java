package TopInterview150.C12_GraphGeneral;
import java.util.*;
public class T200_NumberofIslands {
  public static void main(String[] args) {
    char[][] a = {
       {'1', '0', '1', '1', '0', '1', '1'}};
    System.out.println(numIslands(a));
  }
  static int[] dp = {-1, 0, 1, 0};
  public static int numIslands(char[][] grid) {
    int z = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          z++;
          grid[i][j] = '*';
          num(grid, i, j);
        }
      }
    }
    return z;
  }
  public static void num(char[][] grid, int y, int x) {
    Deque<int[]> d = new ArrayDeque<>();
    d.add(new int[]{x, y});
    while (!d.isEmpty()) {
      int[] c = d.poll();
      for (int i = 0; i < dp.length; i++) {
        int nx = c[0] + dp[i];
        int ny = c[1] + dp[(i + 1) % 4];
        if (nx >= 0 && nx < grid[0].length && ny >= 0 && ny < grid.length && grid[ny][nx] == '1') {
          grid[ny][nx] = '*';
          d.add(new int[]{nx, ny});
        }
      }
    }
  }
}
