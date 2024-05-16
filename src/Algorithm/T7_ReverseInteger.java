// https://leetcode.com/problems/reverse-integer/description/
package Algorithm;
public class T7_ReverseInteger {
  public static void main(String[] args) {
    System.out.println(reverse(1534236469));
  }
  public static int reverse(int x) {
    long y = x % 10;
    x /= 10;
    while (x != 0) {
      if (y != 0) {
        y *= 10;
      }
      y += x % 10;
      x /= 10;
    }
    int z = (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) ? 0 : (int) y;
    return z;
  }
}
