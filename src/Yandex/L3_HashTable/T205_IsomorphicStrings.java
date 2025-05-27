package Tasks.LeetCode.Yandex.L3_HashTable;

import java.util.HashMap;
import java.util.Map;
public class T205_IsomorphicStrings {
  public static void main(String[] args) {
    System.out.println(isIsomorphic("egg", "add"));
  }
  public static boolean isIsomorphic(String s, String t) {
    int[] a = new int[256];
    int[] b = new int[256];
    if (s.length() != t.length())
      return false;
    for (int i = 0; i < s.length(); i++) {
      int c1 = s.charAt(i);
      int c2 = t.charAt(i);
      if (a[c1] != 0 && a[c1] != c2)
        return false;
      if (b[c2] != 0 && b[c2] != c1)
        return false;
      a[c1] = c2;
      b[c2] = c1;
    }
    return true;
  }
  public static boolean isIsomorphic1(String s, String t) {
    Map<Character, Character> map1 = new HashMap<>();
    Map<Character, Character> map2 = new HashMap<>();
    if (s.length() != t.length())
      return false;
    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      if (map1.containsKey(c1) && map1.get(c1) != c2) {
        return false;
      } else map1.put(c1, c2);
      if (map2.containsKey(c2) && map2.get(c2) != c1) {
        return false;
      } else map2.put(c2, c1);
    }
    return true;
  }
  public boolean isIsomorphic2(String s, String t) {
    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      if (!map.containsKey(c1)) {
        if (map.containsValue(c2)) {
          return false;
        }
        map.put(c1, c2);
      } else {
        if (map.get(c1) != c2) {
          return false;
        }
      }

    }
    return true;
  }
}
