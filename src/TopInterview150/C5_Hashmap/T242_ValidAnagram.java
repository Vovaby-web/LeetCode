// https://leetcode.com/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C5_Hashmap;
public class T242_ValidAnagram {
  public static void main(String[] args) {
    System.out.println(isAnagram("ana", "aan"));
  }
  public static boolean isAnagram(String s, String t) {
    int[] a = new int[26];
    if (s.length() != t.length())
      return false;
    for (int i = 0; i < s.length(); i++)
      a[s.charAt(i) - 'a']++;
    for (int i = 0; i < t.length(); i++) {
      int x = t.charAt(i) - 'a';
      a[x]--;
      if (a[x] < 0)
        return false;
    }
    return true;
  }
}
