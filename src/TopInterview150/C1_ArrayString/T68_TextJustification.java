// https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
import java.util.*;
public class T68_TextJustification {
  public static void main(String[] args) {
    System.out.println((fullJustify(new String[]{"This", "is", "an",
       "example", "of", "text", "justification."}, 16)));
  }
  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ans = new ArrayList<>();
    for (int i = 0, n = words.length; i < n; ) {
      List<String> t = new ArrayList<>();
      t.add(words[i]);
      int cnt = words[i].length();
      i++;
      while (i < n && cnt + 1 + words[i].length() <= maxWidth) {
        cnt += 1 + words[i].length();
        t.add(words[i++]);
      }
      if (i == n || t.size() == 1) {
        String left = String.join(" ", t);
        String right = " ".repeat(maxWidth - left.length());
        ans.add(left + right);
        continue;
      }
      // количество пробелов между словами (t.size() - 1) и один пробел в конце строки
      int spaceWidth = maxWidth - (cnt - t.size() + 1);
      int w = spaceWidth / (t.size() - 1);
      int m = spaceWidth % (t.size() - 1);
      StringBuilder row = new StringBuilder();
      for (int j = 0; j < t.size() - 1; j++) {
        // Затем формируется строка row, где каждое слово из списка t добавляется с учетом
        // количества пробелов между словами.
        // Последняее слово добавляется без дополнительных пробелов.
        row.append(t.get(j));
        row.append(" ".repeat(w + (j < m ? 1 : 0)));
      }
      row.append(t.get(t.size() - 1));
      ans.add(row.toString());
    }
    return ans;
  }
}
