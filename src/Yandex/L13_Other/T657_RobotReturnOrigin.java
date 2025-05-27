package Tasks.LeetCode.Yandex.L13_Other;
public class T657_RobotReturnOrigin {
  public static void main(String[] args) {
    System.out.println(judgeCircle("UD"));
  }
  public static boolean judgeCircle(String moves) {
    int[] path = {0, 0};
    for (char c : moves.toCharArray()) {
      switch (c) {
        case 'R':
          path[0]++;
          break;
        case 'L':
          path[0]--;
          break;
        case 'U':
          path[1]--;
          break;
        case 'D':
          path[1]++;
          break;
      }
    }
    return path[0] == 0 && path[1] == 0;
  }
}
