package Tasks.LeetCode.Yandex.L6_SlidingWindow;
import java.util.HashMap;
import java.util.Map;
public class T424_LongestRepeating {
  public static void main(String[] args) {
    System.out.println(characterReplacement("ABAB", 2));  // Вывод: 4
    System.out.println(characterReplacement("AABABBA", 1));  // Вывод: 4
  }
  public static int characterReplacement(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int n = s.length();
    int maxCount = 0;
    int ans = 0;
    int left = 0;
    for (int right = 0; right < n; right++) {
      char c = s.charAt(right);
      map.put(c, map.getOrDefault(c, 0) + 1);
      maxCount = Math.max(maxCount, map.get(c));
      while (right - left + 1 - maxCount > k) {
        char l = s.charAt(left);
        map.put(l, map.get(c) - 1);
        left++;
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }
}

