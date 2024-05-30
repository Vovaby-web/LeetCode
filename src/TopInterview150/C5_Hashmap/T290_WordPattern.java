// https://leetcode.com/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C5_Hashmap;
import java.util.HashMap;
import java.util.Map;
public class T290_WordPattern {
  public static void main(String[] args) {
    System.out.println(wordPattern("aa", "aab"));
  }
  public static boolean wordPattern(String pattern, String s) {
    String[] str=s.split(" ");
    if (str.length!=pattern.length())
      return false;
    Map<Character,String> c1=new HashMap<>();
    Map<String,Character> s1=new HashMap<>();
    int n=pattern.length();
    for (int i=0;i<n;i++){
      char c=pattern.charAt(i);
      if (c1.containsKey(c)&&!c1.get(c).equals(str[i]))
        return false;
      if (s1.containsKey(str[i])&&s1.get(str[i])!=c)
        return false;
      c1.put(c,str[i]);
      s1.put(str[i],c);
    }
    return true;
  }
}
