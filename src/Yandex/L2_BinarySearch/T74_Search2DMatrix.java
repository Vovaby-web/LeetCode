// https://leetcode.com/problems/search-a-2d-matrix/description/
package Yandex.L2_BinarySearch;
public class T74_Search2DMatrix {
  public static void main(String[] args) {
    int[][] a = {{1}, {3}};
    int target = 3;
    System.out.println(searchMatrix1(a, target));
  }
  public static boolean searchMatrix(int[][] matrix, int target) {
    // Создаем нижнюю и верхнюю границу
    int up = 0;
    int down = matrix.length - 1;
    while (up <= down) {
      // Ищем середину по вертикали
      int midVert = up + (down - up) / 2;
      // Создаем левую и правую границу по горизонтали
      int left = 0;
      int right = matrix[midVert].length - 1;
      int midGor = left + (right - left) / 2;
      while (left <= right) {
        // Ищем середину по горизонтали
        midGor = left + (right - left) / 2;
        // Если наше значение < target, то здвигаем левую границу
        if (matrix[midVert][midGor] < target) {
          left = midGor + 1;
        } else
          // Иначе сдвигаем правую границу
          right = midGor - 1;
        // Если мы нашли наше число, то выходим
        if (matrix[midVert][midGor] == target)
          return true;
      }
      // Если наш индекс сместился к правой границе, значит число необходимо искать
      // выше, т.е. наше искомое число target больше всех чисел в массиве
      if (midGor == matrix[midVert].length - 1 && matrix[midVert][midGor] < target) {
        up = midVert + 1;
        // Иначе его надо искать ниже
      } else down = midVert - 1;
    }
    return false;
  }
  public static boolean searchMatrix1(int[][] matrix, int target) {
    int m=matrix.length;
    int n=matrix[0].length;
    int left=0;
    int right=m-1;
    while (left<=right){
      int l=0;
      int r=n-1;
      int mid=(left+right)/2;
      while(l<=r){
        int md=(l+r)/2;
        if (matrix[mid][md]<target){
          l=md+1;
        }else if (matrix[mid][md]>target){
          r=md-1;
        }else return true;
      }
      if (r<0){
        right=mid-1;
      }else left=mid+1;
    }
    return false;
  }
}
