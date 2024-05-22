// https://leetcode.com/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
import java.util.Arrays;
public class T6_ZigzagConversion {
  public static void main(String[] args) {
    System.out.println(convert("PAYPALISHIRING",3));
  }
  public static String convert(String s, int numRows) {
    if (numRows <= 1)
      return s;
    StringBuilder[] str=new StringBuilder[numRows];
    Arrays.setAll(str, k->new StringBuilder());
    int i=0;
    int j=-1;
    for (char c:s.toCharArray()){
      str[i].append(c);
      if (i==0||i==numRows-1){
        j*=-1;
      }
      i+=j;
    }
    return String.join("",str);
  }
}
