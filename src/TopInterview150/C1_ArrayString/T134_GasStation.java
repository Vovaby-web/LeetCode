// https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T134_GasStation {
  public static void main(String[] args) {
    System.out.println(canCompleteCircuit(new int[]{5, 2, 3, 4, 1}, new int[]{2, 4, 5, 1, 3}));
  }
  public static int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int[] a = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = gas[i] - cost[i];
      sum += a[i];
    }
    if (sum < 0) {
      return -1;
    }
    sum = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i];
      if (sum < 0) {
        sum = 0;
        ans = i + 1;
      }
    }
    return ans;
  }
}

