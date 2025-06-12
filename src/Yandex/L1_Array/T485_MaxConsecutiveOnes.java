package Yandex.L1_Array;
public class T485_MaxConsecutiveOnes {
  public static void main(String[] args) {
    System.out.println(maxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
  }
  private static int maxConsecutiveOnes(int[] a) {
    int ans = 0;
    int count = 0;
    for (int x : a) {
      if (x == 1)
        count++;
      else count = 0;
      ans = Math.max(ans, count);
    }
    return ans;
  }
}
