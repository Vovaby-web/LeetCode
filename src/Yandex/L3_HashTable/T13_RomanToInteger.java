package Tasks.LeetCode.Yandex.L3_HashTable;
import java.util.HashMap;
import java.util.Map;
public class T13_RomanToInteger {
  public static void main(String[] args) {
    System.out.println(romanToInt("MCMXCIV"));
  }
  public static int romanToInt(String s) {
    int ans = 0;
    Map<Character, Integer> map = Map.of(
       'I', 1,
       'V', 5,
       'X', 10,
       'L', 50,
       'C', 100,
       'D', 500,
       'M', 1000);
    int i = s.length() - 1;
    while (i >= 0) {
      char c = s.charAt(i);
      if (c == 'M') {
        if (i > 0 && s.charAt(i - 1) == 'C') {
          ans += map.get(c) - 100;
          i--;
        } else ans += map.get(c);
      } else if (c == 'D') {
        if (i > 0 && s.charAt(i - 1) == 'C') {
          ans += map.get(c) - 100;
          i--;
        } else ans += map.get(c);
      } else if (c == 'C') {
        if (i > 0 && s.charAt(i - 1) == 'X') {
          ans += map.get(c) - 10;
          i--;
        } else ans += map.get(c);
      } else if (c == 'L') {
        if (i > 0 && s.charAt(i - 1) == 'X') {
          ans += map.get(c) - 10;
          i--;
        } else ans += map.get(c);
      } else if (c == 'X') {
        if (i > 0 && s.charAt(i - 1) == 'I') {
          ans += map.get(c) - 1;
          i--;
        } else ans += map.get(c);
      } else if (c == 'V') {
        if (i > 0 && s.charAt(i - 1) == 'I') {
          ans += map.get(c) - 1;
          i--;
        } else ans += map.get(c);
      } else if (c == 'I')
        ans += map.get(c);
      i--;
    }
    return ans;
  }
}
