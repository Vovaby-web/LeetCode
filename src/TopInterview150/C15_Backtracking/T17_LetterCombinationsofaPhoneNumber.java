// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C15_Backtracking;
import java.util.*;
public class T17_LetterCombinationsofaPhoneNumber {
  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }
  public static List<String> letterCombinations1(String digits) {
    List<String> ans = new ArrayList<>();
    if (digits.length() == 0)
      return ans;
    ans.add("");
    String[] d = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    for (char i : digits.toCharArray()) {
      String s = d[i - '2'];
      List<String> t = new ArrayList<>();
      for (String a : ans) {
        for (String b : s.split(""))
          t.add(a + b);
      }
      ans = t;
    }
    return ans;
  }
  private static final String[] d = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  private static String digits;
  private static List<String> ans = new ArrayList<>();
  private static StringBuilder t = new StringBuilder();
  public static List<String> letterCombinations(String digit) {
    if (digit.length() == 0)
      return ans;
    digits = digit;
    dfs(0);
    return ans;
  }
  private static void dfs(int i) {
    if (i == digits.length()) {
      ans.add(t.toString());
      return;
    }
    String s = d[digits.charAt(i) - '2'];
    for (char c : s.toCharArray()) {
      t.append(c);
      dfs(i + 1);
      t.deleteCharAt(t.length() - 1);
    }
  }
}
