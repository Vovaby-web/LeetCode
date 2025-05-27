package Tasks.LeetCode.Yandex.L3_HashTable;
import java.util.*;
public class T380_InsertDeleteGetRandom{
  static class RandomizedSet {
    ArrayList<Integer> list;
    Map<Integer, Integer> map;
    Random random;
    public RandomizedSet() {
      list = new ArrayList<>();
      map = new HashMap<>();
      random = new Random();
    }
    public boolean insert(int val) {
      if (map.containsKey(val)) return false;
      list.add(val);
      map.put(val, list.size() - 1);
      return true;
    }
    public boolean remove(int val) {
      if (!map.containsKey(val))
        return false;
      int index = map.get(val);
      int lastVal = list.getLast();
      map.put(lastVal, index);
      map.remove(val);
      list.set(index, lastVal);
      list.removeLast();
      return true;
    }
    public int getRandom() {
      return list.get(random.nextInt(list.size()));
    }
  }
}
