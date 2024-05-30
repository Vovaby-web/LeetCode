// https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C5_Hashmap;
import java.util.*;
public class T205_IsomorphicStrings {
  public static void main(String[] args) {
    System.out.println(isIsomorphic("aa", "aab"));
  }
  public static boolean isIsomorphic(String s, String t) {
    Map<Character, Character> d1 = new HashMap<>();
    Map<Character, Character> d2 = new HashMap<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char a = s.charAt(i);
      char b = t.charAt(i);
      if (d1.containsKey(a) && d1.get(a) != b) {
        return false;
      }
      if (d2.containsKey(b) && d2.get(b) != a) {
        return false;
      }
      d1.put(a, b);
      d2.put(b, a);
    }
    return true;
  }
}
