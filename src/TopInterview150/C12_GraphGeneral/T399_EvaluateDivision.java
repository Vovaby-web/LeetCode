// https://leetcode.com/problems/evaluate-division/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C12_GraphGeneral;
import java.util.*;
public class T399_EvaluateDivision {
  public static void main(String[] args) {
    List<String> a1 = List.of("a", "b");
    List<String> a2 = List.of("b", "c");
    List<List<String>> s1 = List.of(a1, a2);
    List<String> b1 = List.of("a", "c");
    List<String> b2 = List.of("b", "a");
    List<String> b3 = List.of("a", "e");
    List<String> b4 = List.of("a", "a");
    List<String> b5 = List.of("x", "x");
    List<List<String>> s2 = List.of(b1, b2, b3, b4, b5);
    System.out.println(Arrays.toString(calcEquation(s1, new double[]{2.0, 3.0}, s2)));
  }
  static class Node {
    String name;
    double value;
    public Node(String d, double v) {
      name = d;
      value = v;
    }
  }
  public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, List<Node>> graph = createGraph(equations, values);
    double[] ans = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
    }
    return ans;
  }
  public static double dfs(String s, String d, Set<String> visited, Map<String, List<Node>> graph) {
    if (!(graph.containsKey(s) && graph.containsKey(d)))
      return -1.0;
    if (s.equals(d))
      return 1.0;
    visited.add(s);
    for (Node neigh : graph.get(s)) {
      if (!visited.contains(neigh.name)) {
        double ans = dfs(neigh.name, d, visited, graph);
        if (ans != -1.0) {
          return ans * neigh.value;
        }
      }
    }
    return -1.0;
  }
  public static Map<String, List<Node>> createGraph(List<List<String>> equations, double[] values) {
    Map<String, List<Node>> graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      String a = equations.get(i).get(0);
      String b = equations.get(i).get(1);
      graph.computeIfAbsent(a, k -> new ArrayList()).add(new Node(b, values[i]));
      graph.computeIfAbsent(b, k -> new ArrayList()).add(new Node(a, 1 / values[i]));
    }
    return graph;
  }
}
