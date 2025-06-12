import java.util.*;
public class Test {
  public static void main(String[] args) {
    System.out.println(countPrimes(10));
  }
  private static int countPrimes(int n) {
    boolean[] prime = new boolean[n];
    Arrays.fill(prime, true);
    int count = 0;
    for (int i = 2; i < n; i++) {
      for (int j = 2; j < i; j++) {
        if (!prime[j])
          continue;
        if (i % j == 0)
          prime[i] = false;
      }
      if (prime[i])
        count++;
    }
    return count;
  }
}
