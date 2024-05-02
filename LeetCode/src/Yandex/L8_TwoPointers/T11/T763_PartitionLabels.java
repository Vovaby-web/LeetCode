// https://leetcode.com/problems/partition-labels/description/
package Yandex.L8_TwoPointers.T11;
import java.util.*;
public class T763_PartitionLabels {
  public static void main(String[] args) {
    System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
  }
  public static List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    int n = s.length();
    for (int i = 0; i < n; ++i) {
      last[s.charAt(i) - 'a'] = i;
    }
    List<Integer> result = new ArrayList<>();
    int mx = 0, j = 0;
    for (int i = 0; i < n; ++i) {
      mx = Math.max(mx, last[s.charAt(i) - 'a']);
      if (mx == i) {
        result.add(i - j + 1);
        j = i + 1;
      }
    }
    return result;
  }

}
