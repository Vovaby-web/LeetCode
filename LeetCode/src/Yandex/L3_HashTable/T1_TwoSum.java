package Lessons.LeetCode.Yandex.L3_HashTable;
import java.util.Arrays;
import java.util.HashMap;
public class T1_TwoSum {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 8)));
  }
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff)) {
        return new int[]{map.get(diff),i};
      }else {
        map.put(nums[i],i);
      }
    }
    return new int[]{};
  }
}

