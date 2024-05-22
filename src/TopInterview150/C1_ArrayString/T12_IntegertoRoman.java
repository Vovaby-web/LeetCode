// https://leetcode.com/problems/integer-to-roman/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T12_IntegertoRoman {
  public static void main(String[] args) {
    System.out.println(intToRoman(3749));
  }
  private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  private static final String[] symbols = {
     "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
  };
  public static String intToRoman(int num) {
    StringBuilder r = new StringBuilder();
    for (int i = 0; i < values.length; i++) {
      while (num >= values[i]) {
        r.append(symbols[i]);
        num = num - values[i];
      }
    }
    return r.toString();
  }
}

