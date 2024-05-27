// https://leetcode.com/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C3_SlidingWindow;
import java.util.*;
public class T76_MinimumWindowSubstring {
  public static void main(String[] args) {
    System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
  }
  public static String minWindow(String s, String t) {
    Map<Character, Integer> mask = new HashMap<>();
    Map<Character, Integer> temp = new HashMap<>();
    for (char x : t.toCharArray()) {
      mask.merge(x, 1, Integer::sum);
    }
    String ans = "";
    int m = s.length();
    int n = t.length();
    int l = 0;
    int r = 0;
    int count = 0;
    while (r < m) {
      char x = s.charAt(r++);
      if (mask.containsKey(x)) {
        temp.merge(x, 1, Integer::sum);
        if (mask.get(x) < temp.get(x)) {
          while (l < r && mask.get(s.charAt(l)) < temp.get(s.charAt(l))) {
            temp.merge(s.charAt(l++), -1, Integer::sum);
            while (l < r && !mask.containsKey(s.charAt(l)))
              l++;
            count--;
          }
        }else count++;
        if (count == n) {
          if (ans.length() > s.substring(l, r).length() || ans == "")
            ans = s.substring(l, r);
        }
      }
    }
    return ans;
  }
}
