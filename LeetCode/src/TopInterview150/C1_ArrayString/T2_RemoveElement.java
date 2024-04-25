/*
 Учитывая целочисленный массив nums и целое число val, удалите все вхождения val в nums.
 Порядок элементов может быть изменен. Затем верните количество элементов, в nums которых
 не равны val.
 Учитывайте количество элементов в nums, которые не равны val.
 Чтобы их приняли, вам необходимо сделать следующее:
  Измените массив nums так, чтобы первые k элементы nums содержали элементы, не равные val.
  остальные элементы nums не важны, как и размер nums.
 Возвращаться k.
 int[] nums = [...];               // Входной массив
 int val = ...;                    // Значение, которые требуется удалить
 int[] expectedNums = = [...];     // Ожидаемый ответ правильной длины.
                                   // Он отсортирован без значений, равных val.
 int k = RemoveElement(nums, val); // Вызывает вашу реализацию
 assert k == expectedNums.length;
 сортировка (числа, 0, к);         // Сортируем первые k элементов числа nums
 for (int i = 0; i <expectedNums.length; i++)
   assert nums[i] == expectedNums[i];
 Если все утверждения пройдены, ваше решение будет принято
*/
package Lessons.LeetCode.TopInterview150.C1_ArrayString;

import java.util.Arrays;

public class T2_RemoveElement {
  // Метод при нахождении числа val, смещает оставшейся массив и переставляет наш
  // элемент в конец массива
  private static int removeElement(int[] nums, int val) {
    int limit = nums.length;                 // Наш указатель на конец массива
    // слева от limit будут без val, справа только val
    for (int i = 0; i < limit; i++)          // Цикл до лимита
      if (nums[i] == val) {                  // Если элемент = val
        limit--;                             // Cмещаем указатель, т.к. будем проверять [j+1]
        for (int j = i; j < limit; j++)      // От i до limit
          nums[j] = nums[j + 1];             // Затираем наш элемент val
        nums[nums.length - 1] = val;         // Вставляем наш элемент в конец массива
        i--;                                 // Новый символ, который поместили надо проверить
      }
    return limit;                            // Возвращаем длину полученного массива
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 2, 3};               // Input array
    int val = 3;                             // Value to remove
    int[] expectedNums = {2, 2};             // The expected answer with correct length.
    int k = removeElement(nums, val);        // Calls your implementation
    assert k == expectedNums.length;         // Если лож, то выдает исключение
    Arrays.sort(nums, 0, k);       // Sort the first k elements of nums
    for (int i = 0; i < k; i++) {
      assert nums[i] == expectedNums[i];     // Если лож, то выдает исключение
    }
  }
}
