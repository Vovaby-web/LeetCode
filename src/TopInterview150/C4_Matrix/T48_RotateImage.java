// https://leetcode.com/problems/rotate-image/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C4_Matrix;
import java.util.Arrays;
public class T48_RotateImage {
  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    rotate(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }
  public static void rotate(int[][] matrix) {
    int n = matrix.length;
    // ѕервый цикл идет до середины (n >> 1) строк матрицы.
    // Ќа каждой итерации внутреннего цикла происходит обмен элементов в текущей строке
    // с соответствующими элементами в строке, котора€ находитс€ на том же рассто€нии
    // от середины с противоположной стороны.
    // “аким образом, происходит зеркальное отражение строк относительно середины.
    // ѕосле завершени€ первого цикла матрица будет отражена относительно середины
    for (int i = 0; i < n ; i++) {
      for (int j = 0; j < n>>1; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = temp;
      }
    }
    // ¬торой цикл идет по строкам и столбцам матрицы (i и j соответственно).
    // Ќа каждой итерации внутреннего цикла происходит обмен элементов
    // в позици€х (i, j) и (j, i). Ёто действие равносильно операции транспонировани€ матрицы.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
}
