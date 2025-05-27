package Tasks.LeetCode.Yandex.L4_PrefixSum;
import java.util.HashMap;
import java.util.Map;

public class T974_SubarraySumsDivisibleByK {
  public static void main(String[] args) {
    System.out.println(subArraysDivByK(new int[]{4, -5, 0}, 5));
  }
  public static int subArraysDivByK(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    // Для учета случаев, когда подмассив начинается с первого элемента
    map.put(0, 1);
    int sum = 0;
    int count = 0;
    for (int num : nums) {
      sum += num;
      int remainder = sum % k;
      // В Java остаток может быть отрицательным, корректируем его
      if (remainder < 0) {
        remainder += k;
      }
      if (map.containsKey(remainder)) {
        count += map.get(remainder);
      }
      map.compute(remainder, (a, b) -> (b == null) ? 1 : ++b);
    }
    return count;
  }
  public static int subArraysDivByK1(int[] nums, int k) {
    int ans = 0;
    int prefix = 0;
    int[] count = new int[k];
    count[0] = 1;
    for (int num : nums) {
      prefix = (prefix + num % k + k) % k;
      ans += count[prefix];
      ++count[prefix];
    }
    return ans;
  }
}
