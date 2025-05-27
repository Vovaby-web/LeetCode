package Tasks.LeetCode.Yandex.L7_HashTable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class T2215_FindtheDifferenceofTwoArrays{
  public static void main(String[] args) {
    System.out.println(findDifference(new int[]{1,2,3},new int[]{2,4,6}));
  }
  public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    List<Integer> ans1 = new ArrayList<>();
    List<Integer> ans2 = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    for(int num: nums2){
      set.add(num);
    }
    for(int i: nums1){
      if(!set.contains(i)){
        ans1.add(i);
        set.add(i);
      }
    }
    set.clear();
    for(int num: nums1){
      set.add(num);
    }
    for(int num: nums2){
      if(!set.contains(num)){
        ans2.add(num);
        set.add(num);
      }
    }
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(ans1);
    ans.add(ans2);
    return ans;
  }
}
