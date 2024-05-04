// https://leetcode.com/problems/longest-repeating-character-replacement/description/
package Yandex.L9_SlidingWindow.T480;
public class T424_CharReplacement {
  public static void main(String[] args) {
    System.out.println(characterReplacement("AABACCA", 1));
  }
  // Принцип скользящего окна
  // Сложность - O(n) т.к. мы проходим один раз
  // Память - О(1) потому что мы использовали постоянное пространство,
  // работая с массивом из 26 пробелов, который
  // фиксирован и не зависит от входной строки «s».
  public static int characterReplacement(String s, int k) {
    int[] a = new int[26];
    int n = s.length();
    // Левый указатель скользящего окна — l и r — это правый указатель
    int l = 0;
    int max = 0;
    for (int r = 0; r < n; r++) {
      int cr = s.charAt(r) - 'A';
      int cl = s.charAt(l) - 'A';
      // Подсчет количества каждого символа в строке s
      a[cr]++;
      // Проверяем символ с максимальным количеством вхождений
      max = Math.max(max, a[cr]);
      // Теперь мы проверяем, действительно ли наше текущее окно или нет
      while (r - l + 1 - max > k) {
        // Сдвигаем окно вправо, для этого:
        // Уменьшаем счетчик символа, который был в l, потому что его больше нет в окне
        a[cl]--;
        // Сдвигаем позицию
        l++;
      }
    }
    return n - l;
  }
}
