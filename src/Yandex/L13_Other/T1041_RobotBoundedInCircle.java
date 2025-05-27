// https://leetcode.com/problems/robot-bounded-in-circle/description/
package Tasks.LeetCode.Yandex.L13_Other;
public class T1041_RobotBoundedInCircle{
  public static void main(String[] args) {
    System.out.println(isRobotBounded("GGLLGG"));
  }
  public static boolean isRobotBounded(String instructions) {
    int dir = 0;
    int[] dist = new int[4];
    for (int i = 0; i < instructions.length(); i++) {
      char c = instructions.charAt(i);
      if (c == 'L') {
        dir = (dir + 3) % 4;
      } else if (c == 'R') {
        dir = (dir + 1) % 4;
      } else {
        dist[dir]++;
      }
    }
    return (dist[0] == dist[2] && dist[1] == dist[3]) || (dir != 0);
  }

}
