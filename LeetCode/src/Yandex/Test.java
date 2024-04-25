package Lessons.LeetCode.Yandex;
import java.util.*;
public class Test {
 public static void main(String[] args) {
  char[][] a = {
   {'1', '1', '0', '1', '1'},
   {'1', '1', '0', '1', '0'},
   {'1', '1', '0', '0', '0'},
   {'0', '0', '0', '0', '0'}};
  System.out.println(numIslands(a));
 }
 public static int numIslands(char[][] grid) {
  int result = 0;
  for (int i = 0; i < grid.length; i++) {
   for (int j = 0; j < grid[0].length; j++) {
    if (grid[i][j] == '1') {
     dfs(grid, i, j);
     result++;
    }
   }
  }
  return result;
 }
 public static void dfs(char[][] a, int i, int j) {
  int[] dp = {-1, 0, 1, 0};
  a[i][j] = '0';
  for (int k = 0; k < 4; k++) {
   int y = i + dp[k];
   int x = j + dp[(k + 1) % 4];
   if (y >= 0 && y < a.length && x >= 0 && x < a[0].length && a[y][x] == '1')
    dfs(a, y, x);
  }
 }
}
