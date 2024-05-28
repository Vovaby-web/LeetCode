// https://leetcode.com/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C3_SlidingWindow;
import java.util.*;
public class T76_MinimumWindowSubstring {
  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }
  public static String minWindow(String s, String t) {
    Map<Character, Integer> mask = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (char x:t.toCharArray())
      mask.merge(x, 1, Integer::sum);
    int n=t.length();
    int l = 0;
    int k = -1;
    int min = Integer.MAX_VALUE;
    int count = 0;
    for (int r = 0; r < s.length(); r++) {
      char x = s.charAt(r);
      window.merge(x, 1, Integer::sum);
      mask.merge(x, 0, Integer::sum);
      if (mask.get(x) >= window.get(x)) {
        count++;
      }
      while (count == n) {
        if (r - l + 1 < min) {
          min = r - l + 1;
          k = l;
        }
        char y = s.charAt(l++);
        if (mask.get(y) >= window.get(y)) {
          count--;
        }
        window.merge(y, -1, Integer::sum);
      }
    }
    return k < 0 ? "" : s.substring(k, k + min);
  }
}
