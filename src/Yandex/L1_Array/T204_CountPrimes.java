// https://leetcode.com/problems/count-primes/description/
package Yandex.L1_Array;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;
public class T204_CountPrimes {
  public static void main(String[] args) {
    System.out.println(countPrimesLambda(10));
  }
  // O(n log log n)
  // Метод "Решето Эратосфена"
  public static int countPrimes(int n) {
    boolean[] prime = new boolean[n];
    Arrays.fill(prime, true);
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (prime[i]) {
        count++;
        for (int j = 2 * i; j < n; j += i)
          prime[j] = false;
      }
    }
    return count;
  }
  public static int countPrimesLambda(int n) {
    boolean[] prime = new boolean[n];
    Arrays.fill(prime, true);
    IntStream.range(2, n)
       .filter(i -> prime[i])
       .peek(i -> IntStream.iterate(2 * i, j -> j < n, j -> j + i)
       .forEach(j -> prime[j] = false))
       .count();
    return (int) IntStream.range(2, n).filter(i -> prime[i]).count();
  }
}
