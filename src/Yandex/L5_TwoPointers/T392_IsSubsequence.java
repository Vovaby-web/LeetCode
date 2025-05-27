// https://leetcode.com/problems/is-subsequence/description/
package Tasks.LeetCode.Yandex.L5_TwoPointers;
public class T392_IsSubsequence {
  public static void main(String[] args) {
    System.out.println(isSubsequence("abc", "bc"));
  }
  public static boolean isSubsequence(String s, String t) {
    int n = s.length();
    char[] a = s.toCharArray();
    int i = 0;
    for (char c : t.toCharArray()) {
      if (i < n && a[i] == c)
        i++;
    }
    if (i == n)
      return true;
    else return false;
  }
}
