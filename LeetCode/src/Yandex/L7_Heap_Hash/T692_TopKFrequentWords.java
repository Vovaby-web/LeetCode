// https://leetcode.com/problems/top-k-frequent-words/description/
package Yandex.L7_Heap_Hash;
import java.util.*;
public class T692_TopKFrequentWords {
  public static void main(String[] args) {
    System.out.println(topKFrequent1(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 4));
  }
  public static List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new TreeMap<>();
    for (String s : words) {
      map.compute(s, (a, b) -> b == null ? 1 : ++b);
    }
    return map.entrySet().stream()
      .sorted((a, b) -> b.getValue() - a.getValue())
      .limit(k)
      .map(a -> a.getKey())
      .toList();
  }
  private static List<String> topKeys = null;
  public static List<String> topKFrequent1(String[] words, int k) {
    final Map<String, Integer> map = new HashMap<String, Integer>();
    final List<String> result = new ArrayList<String>();
    return new AbstractList<String>() {
      public String get(int index) {
        init();
        return topKeys.get(index);
      }
      public int size() {
        init();
        return topKeys.size();
      }
      protected void init() {
        if (topKeys != null) {
          return;
        }
        for (String w : words) {
          map.put(w, map.getOrDefault(w, 0) + 1);
        }
        result.addAll(map.keySet());
        Comparator<String> comparator = (String a, String b) -> {
          int res = map.get(b) - map.get(a);
          if (res == 0) res = a.compareTo(b);
          return res;
        };
        Collections.sort(result, comparator);
        topKeys = result.subList(0, k);
      }
    };
  }
}
