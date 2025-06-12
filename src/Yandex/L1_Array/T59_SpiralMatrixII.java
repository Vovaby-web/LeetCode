package Yandex.L1_Array;
import java.util.Arrays;
public class T59_SpiralMatrixII {
  public static void main(String[] args) {
    int[][] a = generateMatrix(3);
    // Вывод на экран двумерного массива
    Arrays.stream(a)
       .forEach(row -> System.out.println(Arrays.toString(row)));
  }
  public static int[][] generateMatrix(int n) {
    int[][] a = new int[n][n];
    int c = 1;
    int left = 0;
    int right = n - 1;
    int up = 0;
    int down = n - 1;
    while (up <= down || left <= right) {
      if (up <= down) {
        for (int j = left; j <= right; j++)
          a[up][j] = c++;
        up++;
      }
      if (left <= right) {
        for (int j = up; j <= down; j++)
          a[j][right] = c++;
        right--;
      }
      if (up <= down) {
        for (int j = right; j >= left; j--)
          a[down][j] = c++;
        down--;
      }
      if (left <= right) {
        for (int j = down; j >= up; j--)
          a[j][left] = c++;
        left++;
      }
    }
    return a;
  }
}
