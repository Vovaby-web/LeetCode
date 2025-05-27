package Tasks.LeetCode.Yandex.L6_SlidingWindow;
import java.util.HashMap;
import java.util.Map;
public class T567_PermutationInString {
  public static void main(String[] args) {
    System.out.println(checkInclusion("ab", "eidbaooo"));
  }
  public static boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> sample = new HashMap<>();
    Map<Character, Integer> current = new HashMap<>();
    int n = s1.length();
    int m = s2.length();
    if (n > m)
      return false;
    for (int i = 0; i < n; i++) {
      char c1 = s1.charAt(i);
      sample.put(c1, sample.getOrDefault(c1, 0) + 1);
      char c2 = s2.charAt(i);
      current.put(c2, current.getOrDefault(c2, 0) + 1);
    }
    if (current.equals(sample))
      return true;
    for (int i = 0; i < m - n; i++) {
      char l = s2.charAt(i);
      current.put(l, current.getOrDefault(l, 0) - 1);
      if (current.get(l) == 0)
        current.remove(l);
      char r = s2.charAt(i + n);
      current.put(r, current.getOrDefault(r, 0) + 1);
      if (current.equals(sample))
        return true;
    }
    return false;
  }
  public static boolean checkInclusion1(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    if (m < n) return false;
    int[] a = new int[26];
    for (int i = 0; i < n; i++) {
      a[s1.charAt(i) - 'a']--;
      a[s2.charAt(i) - 'a']++;
    }
    if (isZero(a)) return true;
    for (int i = n; i < m; i++) {
      a[s2.charAt(i) - 'a']++;
      a[s2.charAt(i - n) - 'a']--;
      if (isZero(a))
        return true;
    }
    return false;
  }
  static boolean isZero(int[] a) {
    for (int i : a) {
      if (i != 0) return false;
    }
    return true;
  }
}

