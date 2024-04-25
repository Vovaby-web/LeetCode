package Lessons.LeetCode.Yandex.L3_HashTable;
import java.util.*;
public class T438_FindAnagrams {
  public static List<Integer> findAnagrams(String s, String p) {
    int n = s.length();
    int m = p.length();
    List<Integer> result = new ArrayList();
    if (n < m) return result;
    char[] k = p.toCharArray();
    Arrays.sort(k);
    p = String.valueOf(k);
    for (int i = 0; i < n - m; i++) {
      char[] c = s.substring(i, i + m).toCharArray();
      Arrays.sort(c);
      if (String.valueOf(c).equals(p))
        result.add(i);
    }
    return result;
  }
}
