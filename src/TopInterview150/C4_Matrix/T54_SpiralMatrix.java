// https://leetcode.com/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C4_Matrix;
import java.util.ArrayList;
import java.util.List;
public class T54_SpiralMatrix {
  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(spiralOrder(matrix));
  }
  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return ans;
    int rowStart = 0;
    int rowEnd = matrix.length - 1;
    int colStart = 0;
    int colEnd = matrix[0].length - 1;
    while (rowStart <= rowEnd && colStart <= colEnd) {
      for (int i = colStart; i <= colEnd; i++) {
        ans.add(matrix[rowStart][i]);
      }
      rowStart++;
      for (int i = rowStart; i <= rowEnd; i++) {
        ans.add(matrix[i][colEnd]);
      }
      colEnd--;
      if (rowStart <= rowEnd) {
        for (int i = colEnd; i >= colStart; i--) {
          ans.add(matrix[rowEnd][i]);
        }
        rowEnd--;
      }
      if (colStart <= colEnd) {
        for (int i = rowEnd; i >= rowStart; i--) {
          ans.add(matrix[i][colStart]);
        }
        colStart++;
      }
    }
    return ans;
  }
}
