// https://leetcode.com/problems/partition-labels/description/
package Yandex.L8_TwoPointers;
import java.util.*;
public class T763_PartitionLabels {
  public static void main(String[] args) {
    System.out.println(partitionLabels("abcabcde"));
  }
  public static List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    int n = s.length();
    for (int i = 0; i < n; ++i) {
      // индексу наше букве запишем последнюю позицию где она находитс€
      last[s.charAt(i) - 'a'] = i;
    }
    List<Integer> result = new ArrayList<>();
    int max = 0;
    int left = 0;
    for (int i = 0; i < n; i++) {
      // max - последн€€ позици€ уже обработанных символов
      // last[s.charAt(i) - 'a'] - это последн€€ позици€ текущего символа
      max = Math.max(max, last[s.charAt(i) - 'a']);
      // ≈сли последн€€ позици€ всех обработанных символов совпадает с текущей позицией
      // значит такие символы дальше не встречаютс€
      if (max == i) {
        // ѕодсчитываем их количество
        result.add(i - left + 1);
        // —двигаем начало следующей части
        left = i + 1;
      }
    }
    return result;
  }
}
