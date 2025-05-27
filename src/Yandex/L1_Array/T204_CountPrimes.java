// https://leetcode.com/problems/count-primes/description/
package Tasks.LeetCode.Yandex.L1_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
public class T204_CountPrimes {
  public static void main(String[] args) {
    System.out.println(countPrimes(10));
  }
  // O(n log log n)
  // Метод "Решето Эратосфена"
  public static int countPrimes(int n) {
    boolean[] primes = new boolean[n];
    Arrays.fill(primes, true);
    int ans = 0;
    for (int i = 2; i < n; i++) {
      if (primes[i]) {
        ans++;
        for (int j = i + i; j < n; j += i) {
          primes[j] = false;
        }
      }
    }
    return ans;
  }
  public int countPrimes1(int n) {
    if (n <= 2) return 0;
    int sqrtN = (int) Math.sqrt(n);
    boolean[] isPrime = new boolean[sqrtN + 1];
    Arrays.fill(isPrime, true);
    for (int i = 2; i * i <= sqrtN; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= sqrtN; j += i) {
          isPrime[j] = false;
        }
      }
    }
    List<Integer> smallPrimes = new ArrayList<>();
    for (int i = 2; i <= sqrtN; i++) {
      if (isPrime[i]) {
        smallPrimes.add(i);
      }
    }
    int numThreads = 2;
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);
    int segmentSize = n / numThreads;
    List<Future<Integer>> results = new ArrayList<>();
    for (int i = 0; i < numThreads; i++) {
      int low = i * segmentSize;
      int high = (i == numThreads - 1) ? n : (i + 1) * segmentSize;
      results.add(executor.submit(() -> countPrimesInRange(low, high, smallPrimes)));
    }
    int totalPrimes = 0;
    for (Future<Integer> future : results) {
      try {
        totalPrimes += future.get();
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    executor.shutdown();
    return totalPrimes;
  }
  private static int countPrimesInRange(int low, int high, List<Integer> smallPrimes) {
    if (low < 2) low = 2;
    boolean[] isPrime = new boolean[high - low];
    Arrays.fill(isPrime, true);
    for (int prime : smallPrimes) {
      int start = Math.max(prime * prime, (low + prime - 1) / prime * prime);
      for (int j = start; j < high; j += prime) {
        isPrime[j - low] = false;
      }
    }
    int count = 0;
    for (boolean b : isPrime) {
      if (b) count++;
    }
    return count;
  }
}
