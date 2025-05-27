package Tasks.LeetCode.Yandex.L5_TwoPointers;
public class T443_StringCompression {
  public static void main(String[] args) {
    System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
  }
  // O(n)
  public static int compress(char[] chars) {
    int l = 0;
    int count = 1;
    int r = 1;
    int i = 0;
    while (r < chars.length) {
      if (chars[r] == chars[l]) {
        count++;
      } else {
        chars[i++] = chars[l];
        if (count > 1) {
          char[] c = String.valueOf(count).toCharArray();
          for (int j = 0; j < c.length; j++)
            chars[i++] = c[j];
        }
        count = 1;
        l = r;
      }
      r++;
    }
    if (l < r) {
      chars[i++] = chars[l];
      if (count > 1) {
        char[] c = String.valueOf(count).toCharArray();
        for (int j = 0; j < c.length; j++)
          chars[i++] = c[j];
      }
    }
    return i;
  }
}
