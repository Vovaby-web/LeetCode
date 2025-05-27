// https://leetcode.com/problems/group-anagrams/description/
package Tasks.LeetCode.Yandex.L3_HashTable;
import java.util.*;
public class T49_GroupAnagramm {
  public static void main(String[] args) {
    String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(groupAnagrams(s));
  }
  // O(n*(k*logk))
  // n - длина массива strs
  // k -длина строк
  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String str = new String(c);
      map.computeIfAbsent(str, k -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(map.values());
  }
}
