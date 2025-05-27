package Tasks.LeetCode.Yandex.L5_TwoPointers;
public class T125_ValidPalindrome {
  public static void main(String[] args) {
    T125_ValidPalindrome o = new T125_ValidPalindrome();
    System.out.println(o.isPalindrome("1a2"));
    System.out.println(o.isPalindrome("A man, a plan, a canal: Panama"));
  }
  public boolean isPalindrome(String s) {
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      while (l < r && isPal(s.charAt(l)) == 0) {
        l++;
      }
      int x = isPal(s.charAt(l));
      while (l < r && isPal(s.charAt(r)) == 0) {
        r--;
      }
      int y = isPal(s.charAt(r));
      if (x == y) {
        l++;
        r--;
      } else
        return false;
    }
    return true;
  }
  private int isPal(char c) {
    if (c >= 'A' && c <= 'Z')
      return c+('a'-'A');
    if (c >= 'a' && c <= 'z')
      return c;
    if (c >= '0' && c <= '9')
      return c;
    return 0;
  }
}
