package Tasks.LeetCode.Yandex.L6_SlidingWindow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class T658_FindKClosestElements {
  public static void main(String[] args) {
    System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
  }
  // O(n)
  public static List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();
    int left = 0;
    int right = arr.length - 1;
    while (right - left >= k) {
      if (x - arr[left] <= arr[right] - x) {
        right--;
      } else {
        left++;
      }
    }
    for (int i = left; i < left + k; i++) {
      result.add(arr[i]);
    }
    return result;
  }
  // O(n)
  public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
    int n = arr.length;
    List<Integer> ans = new LinkedList<>();
    if (n == 1) return List.of(arr[0]);
    int index = 0;
    int min = Math.abs(arr[0] - x);
    for (int i = 1; i < n; i++) {
      if (Math.abs(arr[i] - x) < min) {
        min = Math.abs(arr[i] - x);
        index = i;
      }
    }
    int left = index - 1;
    int right = index + 1;
    ans.add(arr[index]);
    k--;
    while (k > 0 && left >= 0 && right < n) {
      if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
        ans.addFirst(arr[left--]);
        k--;
      } else {
        ans.add(arr[right++]);
        k--;
      }
    }
    while (k > 0 && left >= 0) {
      ans.addFirst(arr[left--]);
      k--;
    }
    while (k > 0 && right < n) {
      ans.add(arr[right++]);
      k--;
    }
    return ans;
  }
  // общая сложность кода составляет O(n log n).
  public static List<Integer> findClosestElements1(int[] arr, int k, int x) {
    Integer[] a = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    Arrays.sort(a, (b, c) -> Math.abs(b - x) - Math.abs(c - x));
    return Arrays.stream(a).limit(k).sorted().toList();
  }
}
