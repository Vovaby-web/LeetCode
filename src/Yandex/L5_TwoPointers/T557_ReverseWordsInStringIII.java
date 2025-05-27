// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
package Tasks.LeetCode.Yandex.L5_TwoPointers;
public class T557_ReverseWordsInStringIII {
  public static void main(String[] args) {
    System.out.println(reverseWords("Hello World"));
  }
  public static String reverseWords(String s) {
    int n = s.length();
    int i = 0;
    StringBuilder ans = new StringBuilder();
    while (i < n) {
      int j = s.indexOf(" ", i);
      if (j == -1)
        j = n;
      StringBuilder temp = new StringBuilder(s.substring(i, j));
      if (i != 0)
        ans.append(" ");
      ans.append(temp.reverse());
      i = j + 1;
    }
    return ans.toString();
  }
}
