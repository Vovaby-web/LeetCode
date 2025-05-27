package Tasks.LeetCode.Yandex.L6_SlidingWindow;
import java.util.HashMap;
import java.util.Map;
public class T159_LongestSubstring {
  public static void main(String[] args) {
    System.out.println(longestSubstring("eceba"));
  }
  public static int longestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int ans = 0;
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      char r = s.charAt(right);
      map.put(r, map.getOrDefault(r, 0) + 1);
      while (map.size() > 2) {
        char l = s.charAt(left++);
        map.put(l, map.get(l) - 1);
        if (map.get(l) == 0) {
          map.remove(l);
        }
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }
}
