import java.util.*;
public class Test {
  public static void main(String[] args) {
    String s = "tmmzuxt";
    Map<Character, Integer> map = new HashMap<>();
    int n = s.length();
    int ans = 0;
    for (int r = 0, l = 0; r < n; r++) {
      char c = s.charAt(r);
      if (map.containsKey(c)) {
        if (map.get(c)>=l)
         l = map.get(c) + 1;
      }
      ans = Math.max(ans, r - l + 1);
      map.put(c, r);
    }
    System.out.println(ans);
  }
}
