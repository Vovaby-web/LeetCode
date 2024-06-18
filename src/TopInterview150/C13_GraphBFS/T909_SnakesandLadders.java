// https://leetcode.com/problems/snakes-and-ladders/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C13_GraphBFS;
import java.util.*;
public class T909_SnakesandLadders {
  private static int n;
  public static void main(String[] args) {
    System.out.println(snakesAndLadders(new int[][]
       {{-1, -1, -1, -1, -1, -1},
          {-1, -1, -1, -1, -1, -1},
          {-1, -1, -1, -1, -1, -1},
          {-1, 35, -1, -1, 13, -1},
          {-1, -1, -1, -1, -1, -1},
          {-1, 15, -1, -1, -1, -1}}));
  }
  public static int snakesAndLadders(int[][] board) {
    n = board.length;
    Deque<Integer> q = new ArrayDeque<>();
    q.offer(1);
    boolean[] vis = new boolean[n * n + 1];
    vis[1] = true;
    int ans = 0;
    while (!q.isEmpty()) {
      for (int i = q.size(); i > 0; i--) {
        int curr = q.poll();
        if (curr == n * n)
          return ans;
        for (int j = curr + 1; j <= Math.min(curr + 6, n * n); j++) {
          int[] p = get(j);
          int next = j;
          int y = p[0];
          int x = p[1];
          if (board[y][x] != -1)
            next = board[y][x];
          if (!vis[next]) {
            vis[next] = true;
            q.offer(next);
          }
        }
      }
      ans++;
    }
    return -1;
  }
  private static int[] get(int z) {
    int y = (z - 1) / n;
    int x = (z - 1) % n;
    if (y % 2 == 1)
      x = n - 1 - x;
    return new int[]{n - 1 - y, x};
  }
  public static int snakesAndLadders1(int[][] board) {
    int n = board.length;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);
    boolean[] visited = new boolean[n * n + 1];
    for (int ask = 0; !queue.isEmpty(); ask++) {
      for (int size = queue.size(); size > 0; size--) {
        int num = queue.poll();
        if (visited[num])
          continue;
        visited[num] = true;
        if (num == n * n)
          return ask;
        for (int i = 1; i <= 6 && num + i <= n * n; i++) {
          int next = num + i;
          int value = getBoardValue(board, next);
          if (value > 0)
            next = value;
          if (!visited[next])
            queue.offer(next);
        }
      }
    }
    return -1;
  }
  private static int getBoardValue(int[][] board, int num) {
    int n = board.length;
    int r = (num - 1) / n;
    int y = n - 1 - r;
    int x = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
    return board[y][x];
  }
}
