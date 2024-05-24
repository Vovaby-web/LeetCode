// https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C3_SlidingWindow;
import java.util.*;
public class T3_LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring1("aabaab!bb"));
  }
  public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int l = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (!set.contains(c)) {
        set.add(c);
        ans = Math.max(ans, set.size());
      } else {
        while (set.contains(c)) {
          set.remove(s.charAt(l++));
        }
        set.add(c);
      }
    }
    return ans;
  }
  public static int lengthOfLongestSubstring1(String s) {
    int n = s.length();
    HashMap<Character, Integer> map = new HashMap<>();
    int ans = 0;
    int l = 0;
    int r = 0;
    while (r < n) {
      char c = s.charAt(r);
      if (map.containsKey(c))
        l = Math.max(map.get(c) + 1, l);
      map.put(c, r++);
      ans = Math.max(ans, r - l);
    }
    return ans;
  }
}
