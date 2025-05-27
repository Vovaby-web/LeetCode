package Tasks.LeetCode.Yandex.L3_HashTable;
import java.util.*;
public class T2657_FindPrefixCommonArrayTwoArrays {
  public static void main(String[] args) {
    System.out.println(
       Arrays.toString(findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4}))
    );
  }
  public static int[] findThePrefixCommonArray(int[] A, int[] B) {
    int n = A.length;
    Map<Integer, Integer> matrix = new HashMap<>();
    int[] ans = new int[n];
    int count = 0;
    for (int i = 0; i < n; ++i) {
      matrix.merge(A[i], 1, Integer::sum);
      if (matrix.get(A[i]) == 2)
        count++;
      matrix.merge(B[i], 1, Integer::sum);
      if (matrix.get(B[i]) == 2)
        count++;
      ans[i] += count;
    }
    return ans;
  }
  public static int[] findThePrefixCommonArray1(int[] A, int[] B) {
    int n = A.length;
    Set<Integer> setA = new HashSet<>();
    Set<Integer> setB = new HashSet<>();
    int count = 0;
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      setA.add(A[i]);
      setB.add(B[i]);
      if (setB.contains(A[i]))
        count++;
      if (setA.contains(B[i]))
        count++;
      if (A[i] == B[i])
        count--;
      ans[i] = count;
    }
    return ans;
  }
}
