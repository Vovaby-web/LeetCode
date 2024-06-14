import java.util.*;
public class Test {
  public static void main(String[] args) {
    List<String> a1 = List.of("a", "b");
    List<String> a2 = List.of("b", "c");
    List<String> a3 = List.of("c", "e");
    List<List<String>> s1 = List.of(a1, a2,a3);
    List<String> b1 = List.of("a", "e");
    List<List<String>> s2 = List.of(b1);
    System.out.println(Arrays.toString(calcEquation(s1, new double[]{2.0, 3.0, 5.0}, s2)));
  }
  public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, Map<String,Double>> map = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      String a=equations.get(i).get(0);
      String b=equations.get(i).get(1);
      map.computeIfAbsent(a,k->new HashMap<>()).put(b,values[i]);
      map.computeIfAbsent(b,k->new HashMap<>()).put(a,1.0/values[i]);
    }
    double[] ans = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      ans[i] = dfs(map, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
    }
    return ans;
  }
  private static double dfs(Map<String, Map<String,Double>> m, String a, String b, Set<String> visited) {
    if (!(m.containsKey(a) && m.containsKey(b)))
      return -1;
    if (a.equals(b))
      return 1;
    visited.add(a);
    for (Map.Entry<String, Double> e:m.get(a).entrySet()) {
      if (!visited.contains(e.getKey())) {
        double x = dfs(m, e.getKey(), b, visited);
        if (x != -1)
          return x * e.getValue();
      }
    }
    return -1;
  }
}
