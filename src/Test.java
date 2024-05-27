import java.util.*;
public class Test {
  public static void main(String[] args) {
    System.out.println(findSubstring("barfoofoobarthefoobarman",
       new String[]{"bar", "foo", "the"}));
  }
  public static List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer> mask = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    int m = s.length();
    int n = words.length;
    int k = words[0].length();
    for (String x : words)
      mask.merge(x, 1, Integer::sum);
    for (int i = 0; i < k; i++) {
      Map<String, Integer> temp = new HashMap<>();
      int left = i;
      int right = i;
      int count = 0;
      while (right + k <= m) {
        String x = s.substring(right, right + k);
        count++;
        right += k;
        if (!mask.containsKey(x)) {
          temp.clear();
          left = right;
          count = 0;
          continue;
        }
        temp.merge(x, 1, Integer::sum);
        while (mask.get(x) < temp.get(x)) {
          String rem = s.substring(left, left + k);
          temp.remove(rem);
          left += k;
          count--;
        }
        if (count == n)
          ans.add(left);
      }
    }
    return ans;
  }
}
