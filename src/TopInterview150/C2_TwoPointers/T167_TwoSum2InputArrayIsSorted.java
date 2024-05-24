//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C2_TwoPointers;
import java.util.Arrays;
public class T167_TwoSum2InputArrayIsSorted {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
  }
  public static int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      if (target > numbers[left] + numbers[right]) {
        left++;
      }
      if (target < numbers[left] + numbers[right]) {
        right--;
      }
      if (target == numbers[left] + numbers[right])
        return new int[]{left, right};
    }
    return new int[]{};
  }
}
