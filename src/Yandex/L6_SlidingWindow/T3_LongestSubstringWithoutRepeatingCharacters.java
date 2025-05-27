package Tasks.LeetCode.Yandex.L6_SlidingWindow;
import java.util.HashSet;
import java.util.Set;
public class T3_LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }
  public static int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int ans = 0;
    int n = s.length();
    int left = 0;
    for (int right = 0; right < n; right++) {
      char c = s.charAt(right);
      while (set.contains(c)) {
        set.remove(s.charAt(left++));
      }
      set.add(c);
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }
}
