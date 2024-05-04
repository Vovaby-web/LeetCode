// https://leetcode.com/problems/longest-substring-without-repeating-characters/
import java.util.*;
public class Test {
  public static void main(String[] args) {
    System.out.println(characterReplacement("  "));
  }
  public static int characterReplacement(String s) {
    int n = s.length();
    int[] a = new int[33];
    int j = 0;
    int max = (n == 0) ? 0 : 1;
    for (int i = 0; i < n; i++) {
      int ci = (s.charAt(i)==32)?s.charAt(i):s.charAt(i)-'a';
      a[ci]++;
      if (a[ci] > 1) {
        j = i;
      }
      max = Math.max(max, i - j + 1);
    }
    return max;
  }
}
