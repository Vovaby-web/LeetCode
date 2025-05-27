package Tasks.LeetCode.Yandex.L6_SlidingWindow;
import java.util.HashMap;
import java.util.Map;
public class T76_MinimumWindowSubstring {
  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }
  // O(n)
  public static String minWindow(String s, String t) {
    int m = t.length();
    int n = s.length();
    if (s.isEmpty() || t.isEmpty() || n < m)
      return "";
    Map<Character, Integer> sample = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    for (char c : t.toCharArray())
      sample.put(c, sample.getOrDefault(c, 0) + 1);
    int samLen = sample.size();
    int winLen = 0;
    int left = 0;
    int first = 0;
    int last = 0;
    int len = Integer.MAX_VALUE;
    for (int right = 0; right < n; right++) {
      char c = s.charAt(right);
      window.put(c, window.getOrDefault(c, 0) + 1);
      if (sample.containsKey(c) && sample.get(c).intValue() == window.get(c).intValue()) {
        winLen++;
      }
      while (left <= right && winLen == samLen) {
        if (right - left + 1 < len) {
          first = left;
          last = right + 1;
          len = right - left + 1;
        }
        c = s.charAt(left++);
        window.put(c, window.getOrDefault(c, 0) - 1);
        if (sample.containsKey(c) && window.get(c) < sample.get(c)) {
          winLen--;
        }
      }
    }
    return len == Integer.MAX_VALUE ? "" : s.substring(first, last);
  }
}
