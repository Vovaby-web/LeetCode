// https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T58_LengthofLastWord {
  public static void main(String[] args) {
    System.out.println(lengthOfLastWord("Hello World"));
  }
  public static int lengthOfLastWord(String s) {
    int n = s.length();
    int l = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) != ' ') {
        l++;
      } else {
        if (l > 0)
          return l;
      }
    }
    return l;
  }
}
