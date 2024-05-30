// https://leetcode.com/problems/valid-anagram/
package Yandex.L3_HashTable;
import java.util.Arrays;
public class T242_ValidAnagram {
  public static void main(String[] args) {
    System.out.println(isAnagram("ana", "aan"));
  }
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] sc = s.toCharArray();
    Arrays.sort(sc);
    char[] tc = t.toCharArray();
    Arrays.sort(tc);
    return String.valueOf(sc)
      .equals(String.valueOf(tc));
  }
/*  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    // 26 символов в английском алфавите
    int[] str = new int[26];
    for (int i = 0; i < s.length(); i++) {
      // Т.к. код символа a = 97, то при вычитании a мы получим номер от 0 до 25
      // Прибавляем к коду символа +1
      str[s.charAt(i) - 'a']++;
      // Прибавляем от кода символа -1
      str[t.charAt(i) - 'a']--;
    }
    // Проверяем все символы
    for (int i = 0; i < 26; ++i) {
      // Если есть не нулевой символ, значит есть несовпадение
      if (str[i] != 0) {
        return false;
      }
    }
    return true;
  }*/
}
