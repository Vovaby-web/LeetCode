package Yandex.L1_Array;
import java.util.Arrays;
public class T48_RotateImage{
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(rotate(a)));
    }
    private static int[][] rotate(int[][] a) {
        int n = a.length;
        int m=n-1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n-i-1; j++) {
                int temp = a[i][j];
                a[i][j] = a[m-j][i];
                a[m-j][i] = a[m-i][m-j];
                a[m-i][m-j] = a[j][m-i];
                a[j][m-i] = temp;
            }
        }
        return a;
    }
    private static int[][] rotate1(int[][] a) {
        int n = a.length;
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][(n - 1) - j] = a[j][i];
            }
        }
        return b;
    }
}

