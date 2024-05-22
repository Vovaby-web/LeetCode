// https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T151_ReverseWordsinaString {
  public static void main(String[] args) {
    System.out.println(reverseWords1("a good   example"));
  }
 // Time complexity:O(n)
 // Space complexity:O(n)
  public static String reverseWords(String s) {
    String[] st = s.split(" ");
    int n = st.length;
    StringBuilder ant = new StringBuilder();
    for (int i = n - 1; i >= 0; i--) {
      if (!st[i].strip().isEmpty())
        ant.append(st[i].strip() + " ");
    }
    return ant.toString().strip();
  }
  public static String reverseWords1(String s) {
    char[] str = s.toCharArray();
    char[] res = new char[s.length() + 1];
    int l = s.length() - 1;
    int j;
    int k = 0;
    while (l >= 0) {
      // Убираем все пробелы справа
      while (l >= 0 && str[l] == ' ') {
        l--;
      }
      if (l < 0)
        break;
      j = l;
      while (l >= 0 && str[l] != ' ') {
        l--;
      }
      for (int i = l + 1; i <= j; i++) {
        res[k++] = str[i];
      }
      res[k++] = ' ';
    }
    return new String(res, 0, k - 1);
  }
}
