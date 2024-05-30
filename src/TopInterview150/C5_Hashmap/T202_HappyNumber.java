// https://leetcode.com/studyplan/top-interview-150/
package TopInterview150.C5_Hashmap;
import java.util.HashSet;
import java.util.Set;
public class T202_HappyNumber {
  public static void main(String[] args) {
    System.out.println(isHappy(19));
  }
  public static boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    while (!set.contains(n) && n != 1) {
      set.add(n);
      int x = 0;
      while (n != 0) {
        int z = n % 10;
        n /= 10;
        x += z * z;
      }
      n = x;
    }
    return n == 1;
  }
}
