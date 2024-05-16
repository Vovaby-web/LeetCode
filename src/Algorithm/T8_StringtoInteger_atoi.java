package Algorithm;
public class T8_StringtoInteger_atoi {
  public static void main(String[] args) {
    System.out.println(myAtoi("1337c0d3"));
  }
  public static int myAtoi(String s) {
    int n = s.length();
    if (s.isEmpty() || n == 0) {
      return 0;
    }
    int i = 0;
    while (s.charAt(i) == ' ') {
      if (++i == n)
        return 0;
    }
    int x = 1;
    if (s.charAt(i) == '-')
      x = -1;
    if (s.charAt(i) == '-' || s.charAt(i) == '+')
      i++;
    int res = 0;
    int flag = Integer.MAX_VALUE / 10;
    for (; i < n; i++) {
      if (s.charAt(i) < '0' || s.charAt(i) > '9')
        break;
      if (res > flag || (res == flag && s.charAt(i) > '7'))
        return x > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      res = res * 10 + (s.charAt(i) - '0');
    }
    return x * res;
  }
}
