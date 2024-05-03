import java.util.*;
public class Test {
  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(6, 5);
    map.merge(6, 8, Integer::sum);
    System.out.println(map);
  }
}
