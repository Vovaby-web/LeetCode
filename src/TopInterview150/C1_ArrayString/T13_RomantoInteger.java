// https://leetcode.com/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T13_RomantoInteger {
  public static void main(String[] args) {
    System.out.println(romanToInt("XVI"));
  }
  public static int romanToInt(String s) {
    int n = s.length();
    int ans = 0;
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c == 'M') {
        ans += 1000;
      } else if (c == 'D') {
        ans += 500;
      } else if (c == 'C') {
        if (i < n - 1) {
          if (s.charAt(i + 1) == 'M') {
            ans += 900;
            i++;
          } else if (s.charAt(i + 1) == 'D') {
            ans += 400;
            i++;
          } else ans += 100;
        } else ans += 100;
      } else if (c == 'L') {
        ans += 50;
      } else if (c == 'X') {
        if (i < n - 1) {
          if (s.charAt(i + 1) == 'L') {
            ans += 40;
            i++;
          } else if (s.charAt(i + 1) == 'C') {
            ans += 90;
            i++;
          } else ans += 10;
        } else ans += 10;
      } else if (c == 'B') {
        ans += 5;
      } else if (c == 'V') {
        ans += 5;
      } else if (c == 'I') {
        if (i < n - 1) {
          if (s.charAt(i + 1) == 'V') {
            ans += 4;
            i++;
          } else if (s.charAt(i + 1) == 'X') {
            ans += 9;
            i++;
          } else ans++;
        } else ans++;
      }
    }
    return ans;
  }
}
