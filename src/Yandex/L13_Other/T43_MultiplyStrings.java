// https://leetcode.com/problems/multiply-strings/description/
package Tasks.LeetCode.Yandex.L13_Other;
public class T43_MultiplyStrings {
  public static void main(String[] args) {
    System.out.println(multiply("123", "456"));
  }
  public static String multiply(String num1, String num2) {
    if ("0".equals(num1) || "0".equals(num2)) {
      return "0";
    }
    int m = num1.length();
    int n = num2.length();
    int[] a = new int[m + n];
    for (int i = m - 1; i >= 0; i--) {
      int n1 = num1.charAt(i) - '0';
      for (int j = n - 1; j >= 0; j--) {
        int n2 = num2.charAt(j) - '0';
        a[i + j + 1] += n1 * n2;
      }
    }
    for (int i = a.length - 1; i > 0; i--) {
      a[i - 1] += a[i] / 10;
      a[i] %= 10;
    }
    int i = (a[0] == 0) ? 1 : 0;
    StringBuilder ans = new StringBuilder();
    for (; i < a.length; i++) {
      ans.append(a[i]);
    }
    return ans.toString();
  }
}
