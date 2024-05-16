// https://leetcode.com/problems/palindrome-number/
package Algorithm;
public class T9_PalindromeNumber {
  public static void main(String[] args) {
    System.out.println(isPalindrome(121));
  }
  public static boolean isPalindrome(int x) {
    if (x < 0)
      return false;
    int z = x;
    int y = z % 10;
    z /= 10;
    while (z > 0) {
      y = y * 10 + z % 10;
      z /= 10;
    }
    if (y == x)
      return true;
    else return false;
  }
}
