// https://leetcode.com/problems/group-anagrams/description/
package Lessons.LeetCode.Yandex.L3_HashTable;
import java.util.*;
public class T49_GroupAnagramm {
  public static void main(String[] args) {
    String[] s={"eat", "tea", "tan","ate","nat","bat"};
    System.out.println(groupAnagrams(s));
  }
  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] t = s.toCharArray();
      Arrays.sort(t);
      String k = String.valueOf(t);
      // ���� k - ����������, �� ��������� � ������������ ���� - k �������� s
      // ���� ����� �� ����������, �� ������� new ArrayList<>()
      map.computeIfAbsent(k, key -> new ArrayList<>()).add(s);
    }
    // ���������� ��� �������� ArrayList<String> � map
    // � ���� ArrayList
    // ��������� - [[eat, tea, ate], [bat], [tan, nat]]
    return new ArrayList<>(map.values());
  }
}
