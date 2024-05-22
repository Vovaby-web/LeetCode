// https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T14_LongestCommonPrefix {
  public static void main(String[] args) {
    System.out.println(longestCommonPrefix4(new String[]{"flower", "flow", "flight"}));
  }
  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 1)
      return strs[0];
    int n = Integer.MAX_VALUE;
    for (int i = 0; i < strs.length; i++) {
      n = Math.min(n, strs[i].length());
    }
    boolean isFound = false;
    int index = -1;
    for (int i = 0; i < n; i++) {
      char temp = strs[0].charAt(i);
      for (int j = 0; j < strs.length; j++) {
        if (strs[j].charAt(i) != temp) {
          isFound = false;
          break;
        } else {
          isFound = true;
        }
      }
      if (isFound == false) {
        break;
      }
      index = i;
    }
    if (index == -1)
      return "";
    return strs[0].substring(0, index + 1);
  }
  public static String longestCommonPrefix2(String[] strs) {
    if (strs == null)
      return null;
    String s = strs[0];
    for (int i = 1; i < strs.length; i++) {
      int n = s.length() <= strs[i].length() ? s.length() : strs[i].length();
      int j = 0;
      while (j < n && s.charAt(j) == strs[i].charAt(j)) {
        j++;
      }
      s = strs[i].substring(0, j);
    }
    return s;
  }
  public static String longestCommonPrefix3(String[] strs) {
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      while (strs[i].indexOf(prefix, 0) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) {
          return "";
        }
      }
    }
    return prefix;
  }
  // ¬ременна€ сложность: O(S*log(n)), где S Ч сумма всех символов во всех строках,
  // а n Ч количество строк.
  // ѕримен€етс€ двоичный поиск, поэтому временна€ сложность логарифмическа€.
  // ќднако на каждом этапе двоичного поиска алгоритм также сравнивает символы,
  // что приводит к коэффициенту log(n) дл€ каждой строки, что дает O(S log(n)).
  // —ложность пространства: O(1), поскольку дополнительное пространство, кроме
  // префиксной переменной и счетчиков цикла, не используетс€.
  public static String longestCommonPrefix4(String[] strs) {
    int right = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
      right = Math.min(right, strs[i].length());
    }
    int left = 1;
    String prefix = "";
    while (left <= right) {
      int mid = (left + right) / 2;
      if (isCommonPrefix(strs, mid)) {
        prefix = strs[0].substring(0, mid);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return prefix;
  }
  private static boolean isCommonPrefix(String[] strs, int n) {
    String prefix = strs[0].substring(0, n);
    for (int i = 1; i < strs.length; i++) {
      if (!strs[i].startsWith(prefix)) {
        return false;
      }
    }
    return true;
  }
}
