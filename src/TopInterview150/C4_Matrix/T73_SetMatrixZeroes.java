// https://leetcode.com/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C4_Matrix;
import java.util.Arrays;
public class T73_SetMatrixZeroes {
  public static void main(String[] args) {
    int[][] matrix = {{1, 3, 3}, {0, 1, 6}, {7, 8, 9}};
    setZeroes(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }
  public static void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean firstRow = false;
    boolean firstCol = false;
    // Проверяем на 0 первый столбец
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
        firstCol = true;
        break;
      }
    }
    // Проверяем на 0 первую строку
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == 0) {
        firstRow = true;
        break;
      }
    }
    // Проверяем на 0 все остальные строки и столбцы
    // Если нашли 0, то первый столбец и строка = 0
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    // Проходимся по оставшейся матрицы и если первоя строка или столбец =0,
    // то ячейку обнуляем
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    // Но это мы обработали всю матрицу, кроме первой строки и первого столбца,
    // а если там 0 был, то он не обработан, поэтому обрабатываем первую строку или столбец,
    // в которой был 0
    if (firstRow) {
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }
    if (firstCol) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
