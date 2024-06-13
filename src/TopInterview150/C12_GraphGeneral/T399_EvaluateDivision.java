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
  private static Map<String, String> st;
  private static Map<String, Double> da;
  public static double[] calcEquation(
     List<List<String>> equations, double[] values, List<List<String>> queries) {
    int n = equations.size();
    st = new HashMap<>();
    da = new HashMap<>();
    for (List<String> e : equations) {
      st.put(e.get(0), e.get(0));
      st.put(e.get(1), e.get(1));
      da.put(e.get(0), 1.0);
      da.put(e.get(1), 1.0);
    }
    for (int i = 0; i < n; i++) {
      List<String> e = equations.get(i);
      String a = e.get(0);
      String b = e.get(1);
      String pa = Search(a);
      String pb = Search(b);
      if (Objects.equals(pa, pb))
        continue;
      st.put(pa, pb);
      da.put(pa, da.get(b) * values[i] / da.get(a));
    }
    int m = queries.size();
    double[] ans = new double[m];
    for (int i = 0; i < m; i++) {
      String c = queries.get(i).get(0);
      String d = queries.get(i).get(1);
      ans[i] = !st.containsKey(c) || !st.containsKey(d) || !Objects.equals(Search(c), Search(d))
         ? -1.0
         : da.get(c) / da.get(d);
    }
    return ans;
  }
  private static String Search(String x) {
    if (!Objects.equals(st.get(x), x)) {
      String origin = st.get(x);
      st.put(x, Search(st.get(x)));
      da.put(x, da.get(x) * da.get(origin));
    }
    return st.get(x);
  }
}
