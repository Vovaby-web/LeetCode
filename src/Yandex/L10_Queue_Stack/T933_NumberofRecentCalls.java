package Tasks.LeetCode.Yandex.L10_Queue_Stack;
import java.util.*;
public class T933_NumberofRecentCalls {
  class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
      q = new LinkedList<>();
    }
    public int ping(int t) {
      int x = t - 3000;
      while (!q.isEmpty() && q.peek() < x)
        q.poll();
      q.offer(t);
      return q.size();
    }
  }
}
