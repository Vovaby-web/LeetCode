// https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T274_HIndex {
  public static void main(String[] args) {
    System.out.println(hIndex(new int[]{3,0,7,1,5}));
  }
  public static int hIndex(int[] citations) {
    int n = citations.length;
    int[] a = new int[n+1];
    for(int c : citations) {
      if(c >= n) {
        a[n]++;
      } else {
        a[c]++;
      }
    }
    int count = 0;
    for(int i = n; i >= 0; i--) {
      count += a[i];
      if(count >= i) {
        return i;
      }
    }
    return 0;
  }
}
