package Tasks.LeetCode.Yandex.L5_TwoPointers;
public class T161_OneEditDistance {
  public static void main(String[] args) {
    System.out.println(isOneEditDistance("abс", "abсd"));   // true
    System.out.println(isOneEditDistance("abc", "ab"));   // true
    System.out.println(isOneEditDistance("abac", "aac"));  // true
    System.out.println(isOneEditDistance("abc", "a"));    // false
    System.out.println(isOneEditDistance("abc", "abcd")); // true
    System.out.println(isOneEditDistance("abc", "abd"));  // true
  }
  public static boolean isOneEditDistance(String s, String t) {
    int m = s.length();
    int n = t.length();
    // Если разница в длине строк больше 1, то они не могут быть на расстоянии одной редакции
    if (Math.abs(m - n) > 1)
      return false;
    int i = 0, j = 0;
    boolean flag = false;
    while (i < m && j < n) {
      if (s.charAt(i) != t.charAt(j)) {
        if (flag) // Если уже была найдена разница, возвращаем false
          return false;
        flag = true;
        if (m > n) { // Если строки разной длины, двигаем указатель только на длинной строке
          i++;
        } else if (m < n) {
          j++;
        } else { // Если строки одинаковой длины, двигаем оба указателя
          i++;
          j++;
        }
      } else {   // Если символы одинаковы, двигаем оба указателя
        i++;
        j++;
      }
    }
    // В случае, если последние символы неравны и строки имеют
    if (i < m || j < n) {
     return true;
    }
    return flag;
  }
}
