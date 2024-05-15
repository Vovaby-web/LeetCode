// https://leetcode.com/problems/single-number/description/
package Lessons.LeetCode.Yandex.L3_HashTable;
public class T136_OneNumber {
  public static void main(String[] args) {
    System.out.println(singleNumber(new int[]{4, 5, 4}));
  }
  public static int singleNumber(int[] nums) {
    // Изначально побитовая операция не будет иметь никакого числа
    int result = 0;
    for (int i : nums) {
      // Операция XOR (или исключающее ИЛИ) выполняет побитовое сложение без учета переноса.
      // В данном случае, когда мы применяем XOR к двум числам, если биты на соответствующих
      // позициях одинаковые, результат будет 0, а если разные - то 1.
      result ^= i;
    }
    return result;
  }
}
