// https://leetcode.com/problems/longest-repeating-character-replacement/description/
package Yandex.L9_SlidingWindow.T480;
import java.util.*;
public class T424_CharReplacement {
  public static void main(String[] args) {
    System.out.println(characterReplacement("ABAB", 2));
  }
  public static int characterReplacement(String s, int k) {
    int n = s.length();
    int[] a = new int[26];
    int max = 0;
    for (int i = 0; i < n; i++) {
      a[s.charAt(i) - 'a']++;
      if (a[max] < a[s.charAt(i) - 'a'])
        max = s.charAt(i) - 'a';
    }
    int result = a[max];
    for (int i = 0; i < 26; i++) {
      if (i != max && a[i] > 0 && k > 0) {
        if (a[i] < k) {
          result += a[i];
        }
      }
      if (k == 0)
        break;
    }
    return result;
  }
}
