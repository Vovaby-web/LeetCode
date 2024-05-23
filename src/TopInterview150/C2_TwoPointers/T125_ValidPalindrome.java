// https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C2_TwoPointers;
public class T125_ValidPalindrome {
  public static void main(String[] args) {
    System.out.println(isPalindrome1("raca a car"));
  }
  public static boolean isPalindrome(String s) {
    StringBuilder st = new StringBuilder();
    s = s.toLowerCase();
    for (int i = 0; i <= s.length() - 1; i++) {
      if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
         (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
        st.append(s.charAt(i));
    }
    String st1 = st.toString();
    String st2 = st.reverse().toString();
    if (st1.equals(st2)) {
      return true;
    } else return false;
  }
  public static boolean isPalindrome1(String s) {
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      char c1 = s.charAt(l);
      if (c1 >= 'A' && c1 <= 'Z') {
        c1 = (char) (c1 - 'A' + 'a');
      }
      char c2 = s.charAt(r);
      if (c2 >= 'A' && c2 <= 'Z') {
        c2 = (char) (c2 - 'A' + 'a');
      }
      if (!(c1 >= 'a' && c1 <= 'z') && !(c1 >= '0' && c1 <= '9')) {
        l++;
        continue;
      }
      if (!(c2 >= 'a' && c2 <= 'z') && !(c2 >= '0' && c2 <= '9')) {
        r--;
        continue;
      }
      if (c1 == c2) {
        l++;
        r--;
      } else {
        return false;
      }
    }
    return true;
  }
}
