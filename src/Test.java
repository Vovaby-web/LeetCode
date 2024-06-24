import java.util.*;
public class Test {
  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }
  private static final String[] d = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  private static String digits;
  private static List<String> ans = new ArrayList<>();
  private static StringBuilder t = new StringBuilder();
  public static List<String> letterCombinations(String digit) {
    if (digit.length()==0)
      return ans;
    digits=digit;
    dfs(0);
    return ans;
  }
  static void dfs(int i){
    if (i>=digits.length()){
      ans.add(t.toString());
      return;
    }
    String s=d[digits.charAt(i)-'2'];
    for (char c:s.toCharArray()){
     t.append(c);
     dfs(i+1);
     t.deleteCharAt(t.length()-1);
    }
  }
}
