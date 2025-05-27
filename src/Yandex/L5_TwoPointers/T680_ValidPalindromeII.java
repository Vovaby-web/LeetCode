// https://leetcode.com/problems/valid-palindrome-ii/description/
package Tasks.LeetCode.Yandex.L5_TwoPointers;
public class T680_ValidPalindromeII {
  public static void main(String[] args) {
    System.out.println(validPalindrome("abaabca"));
  }
  public static boolean validPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else {
        if (isPalindrome(s, left + 1, right)) {
          return true;
        }else if (isPalindrome(s, left, right - 1)) {
          return true;
        }else return false;
      }
    }
    return true;
  }
  static boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}

