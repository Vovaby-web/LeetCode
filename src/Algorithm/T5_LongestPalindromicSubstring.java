package Algorithm;
public class T5_LongestPalindromicSubstring {
  public static void main(String[] args) {
    System.out.println(longestPalindrome1("babad"));
  }
  public static String longestPalindrome(String s) {
    if (s == null || s.length() < 1) {
      return "";
    }
    int start = 0;
    int end = 0;
    for (int i = 0; i < s.length(); i++) {
      int n1 = find(s, i, i);
      int n2 = find(s, i, i + 1);
      int n = Math.max(n1, n2);
      if (n > end - start) {
        start = i - (n - 1) / 2;
        end = i + n / 2;
      }
    }
    return s.substring(start, end + 1);
  }
  private static int find(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
  static int lo, ro;
  public static String longestPalindrome1(String s) {
    int n = s.length();
    if (n < 2) return s;
    for (int i = 0; i < n; i++) {
      // Определяем нечетную длину
      extend(s, i, i);
      // Определяем четную длину
      extend(s, i, i + 1);
    }
    return s.substring(lo, lo + ro);
  }
  private static void extend(String s, int l, int r) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    if (ro < r - l - 1) {
      lo = l + 1;
      ro = r - l - 1;
    }
  }
}
