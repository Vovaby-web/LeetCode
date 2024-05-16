// https://leetcode.com/problems/zigzag-conversion/description/
package Algorithm;
import java.util.Arrays;
public class T6_ZigzagConversion {
  public static void main(String[] args) {
    System.out.println(convert("PAYPALISHIRING",3));
  }
  public static String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    StringBuilder[] g = new StringBuilder[numRows];
    Arrays.setAll(g, k -> new StringBuilder());
    int i = 0;
    int j = -1;
    for (char c : s.toCharArray()) {
      g[i].append(c);
      if (i == 0 || i == numRows - 1) {
        j = -j;
      }
      i += j;
    }
    return String.join("", g);
  }
}
