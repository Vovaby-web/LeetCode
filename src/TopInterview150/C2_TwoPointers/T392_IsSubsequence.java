// https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C2_TwoPointers;
public class T392_IsSubsequence {
  public static void main(String[] args) {
    System.out.println(isSubsequence("abc","ahbgdc"));
  }
  public static boolean isSubsequence(String s, String t) {
    int i=0;
    int j=0;
    if (s.length()==0)
      return true;
    while (i<t.length()&&j<s.length()){
      if (t.charAt(i)!=s.charAt(j)){
        i++;
      }else {
        i++;
        j++;
      }
    }
    if (j==s.length())
      return true;
    else return false;
  }
}
