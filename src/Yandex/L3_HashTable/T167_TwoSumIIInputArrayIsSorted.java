package Tasks.LeetCode.Yandex.L3_HashTable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class T167_TwoSumIIInputArrayIsSorted {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
  }
  public static int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      int x = target - numbers[i];
      if (map.containsKey(x)) {
        return new int[]{map.get(x), i + 1};
      } else map.put(numbers[i], i + 1);
    }
    return new int[]{-1, -1};
  }
}
