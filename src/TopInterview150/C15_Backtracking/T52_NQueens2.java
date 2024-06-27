package TopInterview150.C15_Backtracking;
public class T52_NQueens2 {
  public static void main(String[] args) {
    System.out.println(totalNQueens(4));
  }
  private static int ans;
  public static int totalNQueens(int n) {
    dfs(n, new boolean[10], new boolean[20], new boolean[20], 0);
    return ans;
  }
  private static void dfs(int n, boolean[] cols, boolean[] dg, boolean[] udg, int i) {
    if (i == n) {
      ans++;
      return;
    }
    for (int j = 0; j < n; j++) {
      int a = i + j;
      int b = i - j + n;
      if (cols[j] || dg[a] || udg[b])
        continue;
      cols[j] = true;
      dg[a] = true;
      udg[b] = true;
      dfs(n, cols, dg, udg, i + 1);
      cols[j] = false;
      dg[a] = false;
      udg[b] = false;
    }
  }
}
