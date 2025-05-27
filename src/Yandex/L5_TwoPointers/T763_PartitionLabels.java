package Tasks.LeetCode.Yandex.L5_TwoPointers;
import java.util.*;
public class T763_PartitionLabels {
  public static void main(String[] args) {
    System.out.println(partitionLabels("ababcbacadefegdehijhklij")); // [9, 7, 8]
  }
  // O(n)
  public static List<Integer> partitionLabels(String s) {
    Map<Character, Integer> map = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    char[] str = s.toCharArray();
    for (int i = 0; i < str.length; i++) {
      char c = s.charAt(i);
      map.put(c, i);
    }
    int left = 0, right = 0;
    for (int i = 0; i < str.length; i++) {
      right = Math.max(right, map.get(str[i]));
      if (i == right) {
        ans.add(right - left + 1);
        left = right + 1;
      }
    }
    return ans;
  }
  public static List<Integer> partitionLabels2(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, i);
    }
    List<Integer> ans = new ArrayList<>();
    int max = map.get(s.charAt(0));
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
      int current = map.get(s.charAt(i));
      if (max < i && count > 0) {
        ans.add(count);
        max = current;
        count = 0;
      } else max = Math.max(max, current);
      count++;
    }
    if (max < s.length() && count > 0) {
      ans.add(count);
    }
    return ans;
  }
  public static List<Integer> partitionLabels1(String s) {
    Map<Character, int[]> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int x = i;
      map.compute(c, (key, value) -> {
        if (value == null) {
          return new int[]{x, x};
        } else {
          value[1] = x;
          return value;
        }
      });
    }
    List<Integer> ans = new ArrayList<>();
    int max = map.get(s.charAt(0))[1];
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
      int current = map.get(s.charAt(i))[1];
      if (max < i && count > 0) {
        ans.add(count);
        max = current;
        count = 0;
      }
      count++;
      max = Math.max(max, current);
    }
    if (max < s.length() && count > 0) {
      ans.add(count);
    }
    return ans;
  }
}
