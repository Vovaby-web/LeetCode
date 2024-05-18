import java.util.*;
public class Test {
  public static void main(String[] args) {
    System.out.println(strStr("mississippi","issipi"));
  }
  public static int strStr(String haystack, String needle) {
    int n=haystack.length();
    int m=needle.length();
    if (n<m)
      return -1;
    int i=0;
    char c=needle.charAt(0);
    while (i<n&&i>=0){
      int x=haystack.indexOf(c,i);
      if (x<0||x+m>n)
        return -1;
      if (needle.equals(haystack.substring(x,x+m)))
        return x;
      i=x+1;
    }
    return -1;
  }
}
