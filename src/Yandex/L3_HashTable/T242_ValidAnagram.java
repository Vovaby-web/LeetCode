// https://leetcode.com/problems/valid-anagram/
package Tasks.LeetCode.Yandex.L3_HashTable;
public class T242_ValidAnagram {
  public static void main(String[] args) {
    System.out.println(isAnagram("ana", "aan"));
  }
  public static boolean isAnagram(String s, String t) {
    int n=s.length();
    int m=t.length();
    if ( n!= m) {
      return false;
    }
    int[] a=new int[26];
    for ( int i=0; i<n; i++ ) {
      int c=s.charAt(i)-'a';
      a[c]++;
    }

    return true;
  }
}

