package Tasks.LeetCode.Yandex.L6_SlidingWindow;
import java.util.*;
public class T438_FindAnagrams {
  public static void main(String[] args) {
    System.out.println(findAnagrams("ddfabc", "abc"));
  }
  public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();
    int[] sample = new int[26];
    int[] window = new int[26];
    int np = p.length();
    int ns = s.length();
    if (np > ns) {
      return ans;
    }
    for (int i = 0; i < np; i++) {
      sample[p.charAt(i) - 'a']++;
      window[s.charAt(i) - 'a']++;
    }
    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (window[i] > sample[i]) {
        count += (window[i] - sample[i]);
      }
    }
    if (count == 0) {
      ans.add(0);
    }
    for (int i = np; i < ns; i++) {
      int r = s.charAt(i) - 'a';
      window[r]++;
      if (window[r] > sample[r]) {
        count++;
      }
      int l = s.charAt(i - np) - 'a';
      window[l]--;
      if (window[l] >= sample[l]) {
        count--;
      }
      if (count == 0) {
        ans.add(i - np + 1);
      }
    }
    return ans;
  }
  public static List<Integer> findAnagrams1(String s, String p) {
    var ans = new ArrayList<Integer>();
    Map<Character, Integer> sample = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    int np = p.length();
    int ns = s.length();
    if (np > ns) {
      return ans;
    }
    int count = 0;
    for (int i = 0; i < np; i++) {
      sample.merge(p.charAt(i), 1, Integer::sum);
    }
    for (int i = 0; i < ns; i++) {
      char r = s.charAt(i);
      window.merge(r, 1, Integer::sum);
      if (sample.containsKey(r)) {
        if (window.get(r) > sample.get(r)) {
          count++;
        }
      } else count++;
      if (i == np - 1) {
        if (count == 0) {
          ans.add(i - np + 1);
        }
      }
      if (i >= np) {
        char l = s.charAt(i - np);
        window.merge(l, -1, Integer::sum);
        if (sample.containsKey(l)) {
          if (window.get(l) >= sample.get(l)) {
            count--;
          }
        } else count--;
        if (count == 0) {
          ans.add(i - np + 1);
        }
      }
    }
    return ans;
  }
}