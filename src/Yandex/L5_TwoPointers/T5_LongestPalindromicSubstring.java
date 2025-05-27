// https://leetcode.com/problems/longest-palindromic-substring/description/
package Tasks.LeetCode.Yandex.L5_TwoPointers;
public class T5_LongestPalindromicSubstring {
  public static void main(String[] args) {
    System.out.println(longestPalindrome("cbbca"));
  }
  // Алгоритм - O(n^2)
  public static String longestPalindrome(String s) {
    if (s == null || s.isEmpty())
      return "";
    int n = s.length();
    int left = 0;
    int right = 0;
    for (int i = 0; i < n; i++) {
      int odd = expandCenter(s, i, i);
      int even = expandCenter(s, i, i + 1);
      int max = Math.max(odd, even);
      if (max > right - left) {
        left = i - (max - 1) / 2;
        right = i + max / 2;
      }
    }
    return s.substring(left, right + 1);
  }
  private static int expandCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() &&
       s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
  // Алгоритм Манакера - O(N)
  public static String longestPalindrome1(String s) {
    // Если строка пустая или имеет длину 1, возвращаем её.
    if (s.length() <= 1)
      return s;
    // Инициализация переменных для хранения максимальной длины палиндрома и самой длинной подстроки.
    int maxLen = 1;
    String maxStr = s.substring(0, 1);
    // Преобразование строки для использования алгоритма Манакера, добавление символов '#'.
    s = "#" + s.replaceAll("", "#") + "#";
    // Длина преобразованной строки.
    int n = s.length();
    // Инициализация массива для хранения радиусов палиндромов.
    int[] dp = new int[n];
    // Инициализация центра и правого края самого длинного палиндрома.
    int center = 0;
    int right = 0;
    // Основной цикл по каждому символу преобразованной строки.
    for (int i = 0; i < n; i++) {
      // Если текущий индекс внутри правого края палиндрома, инициализируем dp[i].
      if (i < right)
        dp[i] = Math.min(right - i, dp[2 * center - i]);
      // Расширение палиндрома вокруг текущего центра i.
      while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < n &&
         s.charAt(i - dp[i] - 1) == s.charAt(i + dp[i] + 1)) {
        dp[i]++;
      }
      // Если новый палиндром выходит за правый край, обновляем центр и правый край.
      if (i + dp[i] > right) {
        center = i;
        right = i + dp[i];
      }
      // Обновление максимальной длины палиндрома и соответствующей подстроки.
      if (dp[i] > maxLen) {
        maxLen = dp[i];
        maxStr = s.substring(i - dp[i], i + dp[i] + 1).replaceAll("#", "");
      }
    }
    // Возврат самой длинной палиндромной подстроки.
    return maxStr;
  }


}