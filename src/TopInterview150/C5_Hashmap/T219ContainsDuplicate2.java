// https://leetcode.com/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C5_Hashmap;
import java.util.*;
public class T219ContainsDuplicate2 {
  public static void main(String[] args) {
    System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
  }
  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> set = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.containsKey(nums[i])) {
        if (i - set.get(nums[i]) <= k)
          return true;
      }
      set.put(nums[i], i);
    }
    return false;
  }
}
