package Tasks.LeetCode.Yandex.L3_HashTable;
import java.util.*;
public class T692_TopKFrequentWords {
  static class Word {
    String s;
    int i;
    public Word(String s, int i) {
      this.s = s;
      this.i = i;
    }
    public boolean equals(Word word) {
      return s.equals(word.s);
    }
  }
  public static void main(String[] args) {
    System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
  }
  public static List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words)
      map.merge(word, 1, Integer::sum);
    PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
      int res = map.get(b) - map.get(a);
      if (res == 0) {
        res = a.compareTo(b);
      }
      return res;
    });
    for (Map.Entry<String,Integer> entry : map.entrySet()) {
      pq.add(entry.getKey());
    }
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < k; i++)
      if (!pq.isEmpty())
        ans.add(pq.poll());
    return ans;
  }
  public static List<String> topKFrequent1(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words)
      map.merge(word, 1, Integer::sum);
    PriorityQueue<Word> pq = new PriorityQueue<>((a, b) -> {
      int res = b.i - a.i;
      if (res == 0) {
        res = a.s.compareTo(b.s);
      }
      return res;
    });
    for (Map.Entry<String,Integer> entry : map.entrySet()) {
      Word word = new Word(entry.getKey(), entry.getValue());
      pq.add(word);
    }
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < k; i++)
      if (!pq.isEmpty())
        ans.add(pq.poll().s);
    return ans;
  }
}
