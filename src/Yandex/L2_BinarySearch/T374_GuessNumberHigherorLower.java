// https://leetcode.com/problems/guess-number-higher-or-lower/description/
package Yandex.L2_BinarySearch;
public class T374_GuessNumberHigherorLower {
  public static void main(String[] args) {
    System.out.println(guessNumber(10));
  }
  public static int guessNumber(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
      int mid = (left + right) / 2;
      if (guess(mid) <= 0) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
  static int pick = 5;
  static int guess(int num) {
    if (num > pick)
      return -1;
    else if (num < pick)
      return 1;
    else return 0;
  }
}
