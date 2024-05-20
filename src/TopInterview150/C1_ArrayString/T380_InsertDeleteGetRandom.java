// https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
import java.util.*;
public class T380_InsertDeleteGetRandom {
  static class RandomizedSet {
    List<Integer> list;
    public RandomizedSet() {
      list=new ArrayList<>();
    }
    public boolean insert(int val) {
      if (list.contains(val)){
        return false;
      }else {
        list.add(val);
        return true;
      }
    }
    public boolean remove(int val) {
      if (list.contains(val)){
        list.removeIf(num -> num == val);
        return true;
      }else {
        return false;
      }
    }
    public int getRandom() {
      Random rnd = new Random();
      return list.get(rnd.nextInt(list.size()));
    }
  }
  public static void main(String[] args) {
    RandomizedSet set=new RandomizedSet();
  }
}
