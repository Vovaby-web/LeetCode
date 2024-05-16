//
package Algorithm;
import java.util.*;
public class T3_LongestSubstring {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring1("abcac"));
  }
  public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int l = 0;
    int r = 0;
    int max = 0;
    for (int i = 0; i < n; i++, r++) {
      char ch = s.charAt(i);
      for (int j = l; j < r; j++) {
        if (ch == s.charAt(j)) {
          l = j + 1;
          break;
        }
      }
      max = Math.max(max, r - l + 1);
    }
    return max;
  }
  public static int lengthOfLongestSubstring1(String s) {
    Set<Character> map = new HashSet<>();
    int l = 0;
    int result = 0;
    for (int r = 0; r < s.length(); r++) {
      char c = s.charAt(r);
      while (map.contains(c)) {
        map.remove(s.charAt(l++));
      }
      map.add(c);
      result = Math.max(result, r - l + 1);
    }
    return result;
  }
  public static int lengthOfLongestSubstring3(String s) {
    int[] a = new int[32];
    int l = 0;
    int result = 0;
    for (int r = 0; r < s.length(); r++) {
      int i = s.charAt(r) - 'a';
      while (a[i] > 0) {
        a[s.charAt(l++) - 'a']--;
      }
      a[i]++;
      result = Math.max(result, r - l + 1);
    }
    return result;
  }
}

