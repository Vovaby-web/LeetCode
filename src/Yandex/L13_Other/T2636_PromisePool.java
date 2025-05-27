package Tasks.LeetCode.Yandex.L13_Other;
import java.util.*;
import java.util.concurrent.*;
public class T2636_PromisePool {
  public static void main(String[] args) throws Exception {
    T2636_PromisePool o = new T2636_PromisePool();
    List<CompletableFuture<Integer>> promises = List.of(
       o.createPromise(1, 300),
       o.createPromise(2, 400),
       o.createPromise(3, 200)
    );
    int limit = 2;
    List<Integer> results = o.promisePool(promises, limit);
    System.out.println(results);
  }
  private CompletableFuture<Integer> createPromise(int value, int delay) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        TimeUnit.MILLISECONDS.sleep(delay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return value;
    });
  }
  private List<Integer> promisePool(List<CompletableFuture<Integer>> promises, int limit) throws Exception {
    ExecutorService executorService = Executors.newFixedThreadPool(limit);
    List<Integer> results = new ArrayList<>();
    for (CompletableFuture<Integer> promise : promises) {
      results.add(promise.whenCompleteAsync((result, throwable) -> {
        if (throwable != null) {
          throwable.printStackTrace();
        }
      }, executorService).get());
    }
    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.MINUTES);
    return results;
  }
}
