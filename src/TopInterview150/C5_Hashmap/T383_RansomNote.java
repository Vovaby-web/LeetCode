// https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C5_Hashmap;
import java.util.HashMap;
import java.util.Map;
public class T383_RansomNote {
  public static void main(String[] args) {
    System.out.println(canConstruct("aa", "aab"));
  }
  public static boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : magazine.toCharArray()) {
      map.merge(c, 1, Integer::sum);
    }
    for (char c : ransomNote.toCharArray()) {
      if (map.containsKey(c)) {
        if (map.get(c) == 0)
          return false;
        else map.merge(c, -1, Integer::sum);
      } else return false;
    }
    return true;
  }
  public static boolean canConstruct1(String ransomNote, String magazine) {
    int[] mag = new int[26];
    for (char c : magazine.toCharArray()) {
      mag[c - 'a']++;
    }
    for (char c : ransomNote.toCharArray()) {
      if (mag[c - 'a'] == 0) {
        return false;
      }
      mag[c - 'a']--;
    }
    return true;
  }
}

