// https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
import java.util.*;
public class T380_InsertDeleteGetRandom {
  static class RandomizedSet<T> {
    Map<T,Integer> m;
    List<T> l;
    public RandomizedSet() {
      m=new HashMap<>();
      l =new ArrayList<>();
    }
    public boolean insert(T val) {
      if (m.containsKey(val)){
        return false;
      }else {
        m.put(val,l.size());
        l.add(val);
        return true;
      }
    }
    public boolean remove(T val) {
      if (m.containsKey(val)){
        l.set(m.get(val),l.get(l.size()-1));
        m.put(l.get(l.size()-1),m.get(val));
        l.remove(l.size()-1);
        m.remove(val);
        return true;
      }else {
        return false;
      }
    }
    public int getRandom() {
      Random rnd = new Random();
      return l.indexOf(rnd.nextInt(l.size()));
    }
  }
  public static void main(String[] args) {
    RandomizedSet s=new RandomizedSet();
    s.insert(5);
    s.insert(8);
    s.insert(10);
    s.insert(12);
    s.remove(8);



  }
}
