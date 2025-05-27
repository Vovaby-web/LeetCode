// https://leetcode.com/problems/reverse-string/description/
package Tasks.LeetCode.Yandex.L5_TwoPointers;
import java.util.Arrays;
public class T344_ReverseString {
  public static void main(String[] args) {
    char[] c = {'h', 'e', 'l', 'l', 'o' };
    reverseString(c);
    System.out.println(Arrays.toString(c));
  }
  public static void reverseString(char[] s) {
    int n = s.length;
    for (int i = 0; i < n / 2; i++) {
      char temp = s[i];
      s[i] = s[n - i - 1];
      s[n - i - 1] = temp;
    }
  }
}
