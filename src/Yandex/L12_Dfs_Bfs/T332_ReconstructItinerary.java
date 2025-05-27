package Tasks.LeetCode.Yandex.L12_Dfs_Bfs;
import java.util.*;
public class T332_ReconstructItinerary {
  public static void main(String[] args) {
    List<List<String>> in = List.of(List.of("MUC","LHR"),
       List.of("JFK","MUC"), List.of("SFO","SJC"),List.of("LHR","SFO"));
    System.out.println(findItinerary(in));
  }
  static List<String> ans = new LinkedList<>();
  public static List<String> findItinerary(List<List<String>> tickets) {
    Map<String, Queue<String>> map = new HashMap<>();
    for (List<String> x : tickets) {
      String from = x.get(0);
      String to = x.get(1);
      map.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
    }
    dfs(map, "JFK");
    return ans;
  }
  private static void dfs(Map<String, Queue<String>> map, String path) {
    Queue<String> current = map.get(path);
    while (current != null && !current.isEmpty()) {
      String str = current.poll();
      dfs(map, str);
    }
    ans.addFirst(path);
  }
}

