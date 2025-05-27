package Tasks.LeetCode.Yandex.L10_Queue_Stack;
import java.util.ArrayList;
import java.util.List;
public class T281_ZigzagIterator{
  public static void main(String[] args) {
    int[] a={1, 2};
    int[] b={3, 4, 5, 6};
    System.out.println(zigzagIterator(a,b));
  }
  private static List<Integer> zigzagIterator(int[] a, int[] b) {
    int n=a.length;
    int m=b.length;
    List<Integer> res = new ArrayList<>();
    boolean flag = true;
    int i=0;
    int j=0;
    while(i<n && j<m){
      if (flag)
        res.add(a[i++]);
      else res.add(b[j++]);
      flag=!flag;
    }
    while(i<n)
      res.add(a[i++]);
    while(j<m)
      res.add(b[j++]);
    return res;
  }
}
