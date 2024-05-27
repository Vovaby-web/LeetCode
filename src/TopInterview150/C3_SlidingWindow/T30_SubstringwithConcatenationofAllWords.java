// https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C3_SlidingWindow;
import java.util.*;
public class T30_SubstringwithConcatenationofAllWords {
  public static void main(String[] args) {
    System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
  }
  public static List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer> mask = new HashMap<>();
    for (String w : words) {
      mask.merge(w, 1, Integer::sum);
    }
    int m = s.length();
    int n = words.length;
    int k = words[0].length();
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      Map<String, Integer> temp = new HashMap<>();
      int left = i;
      int right = i;
      int count = 0;
      while (right + k <= m) {
        String x = s.substring(right, right + k);
        right += k;
        if (!mask.containsKey(x)) {
          temp.clear();
          left = right;
          count = 0;
          continue;
        }
        temp.merge(x, 1, Integer::sum);
        count++;
        while (temp.get(x) > mask.get(x)) {
          String remove = s.substring(left, left + k);
          temp.merge(remove, -1, Integer::sum);
          left += k;
          count--;
        }
        if (count == n) {
          ans.add(left);
        }
      }
    }
    return ans;
  }
}
