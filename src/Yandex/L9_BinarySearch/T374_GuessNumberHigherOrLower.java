// https://leetcode.com/problems/guess-number-higher-or-lower/description/
package Tasks.LeetCode.Yandex.L9_BinarySearch;
public class T374_GuessNumberHigherOrLower {
  public static void main(String[] args) {
    System.out.println(guessNumber(2147483647));
  }
  public static int guessNumber(int n) {
    int left = 0;
    int right = n;
    while (left <= right) {
      long sum = (long) left + (long) right;
      int mid = (int) (sum / 2);
      int num = guess(mid);
      if (num == 1)
        left = mid + 1;
      else if (num == -1)
        right = mid - 1;
      else return mid;
    }
    return 1;
  }
  public static int guess(int num) {
    return Integer.compare(2147483647, num);
  }
}
