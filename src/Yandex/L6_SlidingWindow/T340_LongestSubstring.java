package Tasks.LeetCode.Yandex.L6_SlidingWindow;
import java.util.HashMap;
import java.util.Map;
public class T340_LongestSubstring {
  public static void main(String[] args) {
    System.out.println(longestSubstring("eceba", 2));
  }
  public static int longestSubstring(String s, int k) {
    if (s == null || s.isEmpty() || k == 0)
      return 0;
    int left = 0;
    int ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      map.put(c, map.getOrDefault(c, 0) + 1);
      while (map.size() > k) {
        char x = s.charAt(left);
        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0) {
          map.remove(x);
        }
        left++;
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }
}
