// https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
import java.util.*;
public class T68_TextJustification {
  public static void main(String[] args) {
    System.out.println((fullJustify(new String[]{"This", "is", "an",
       "example", "of", "text", "justification", "on"}, 17)));
  }
  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ans = new ArrayList<>();
    for (int i = 0, n = words.length; i < n; ) {
      List<String> temp = new ArrayList<>();
      int count = words[i].length();
      temp.add(words[i++]);
      while (i < n && count + 1 + words[i].length() <= maxWidth) {
        count += 1 + words[i].length();
        temp.add(words[i++]);
      }
      // i == n потому, что последняя строка должна быть (слово+пробел+слово+недостающие пробелы)
      // "justif on       "
      // t.size() == 1, если одно слово, то мы его заноси в ответ, иначе в дальнейшем
      // w = spaceWidth / (t.size() - 1) будет деление на 0
      if (i == n || temp.size() == 1) {
        String left = String.join(" ", temp);
        String right = " ".repeat(maxWidth - left.length());
        ans.add(left + right);
        continue;
      }
      // count - счетчик длины строки с учетом одного пробела между словами
      // Пример "This is an", count = 10, однако в t пробелов нет и поэтому
      // "This","is","an" длина t = 8
      // Общее число пробелов = длина строки - (счетчик длины строки - поставленные нами пробелы)
      // spaceWidth = 16 - (10 - 8) = 8, т.е. между строчками всего надо поставить 8 пробелов.
      // Однако их надо распределить между словами - количество мест между словами (t.size() - 1).
      // Мы знаем, что фактическая длина нашей строки без пробелов = 8 (Thisisan), для того чтобы
      // превратить ее в 16, необходимо доставить 8 пробелов, т.е. у нас 3 слова и между ними 2 места.
      // Значит (16-8) / (3-1) = 4, т.е. по 4 пробела между словами - переменная - w.
      // А если у нас бы была длина 17 (maxWidth), значит между двумя первыми словами
      // необходимо поставить дополнительный пробел т.к. (17-8) / (3-1) = 4 (остаток 1).
      // Вот поэтому у нас есть переменная - m
      int spaceWidth = maxWidth - (count - (temp.size() - 1));
      int w = spaceWidth / (temp.size() - 1);
      // Один пробел зависит от добавления четности или нечетности пробелов
      int m = spaceWidth % (temp.size() - 1);
      StringBuilder row = new StringBuilder();
      for (int j = 0; j < temp.size(); j++) {
        // Затем формируется строка row, где каждое слово из списка t добавляется с учетом
        // количества пробелов между словами.
        // Последнее слово добавляется без дополнительных пробелов.
        row.append(temp.get(j));
        if (j < temp.size() - 1)
          row.append(" ".repeat(w + (j < m ? 1 : 0)));
      }
      ans.add(row.toString());
    }
    return ans;
  }
}
