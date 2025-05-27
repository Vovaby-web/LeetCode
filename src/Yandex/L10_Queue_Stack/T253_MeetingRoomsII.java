package Tasks.LeetCode.Yandex.L10_Queue_Stack;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
public class T253_MeetingRoomsII {
  public static void main(String[] args) {
    int[][] intervals = {
       {0, 30},
       {5, 10},
       {15, 20}
    };
    System.out.println(minMeetingRooms(intervals));  // Вывод: 2
  }
  // O(n log n)
  public static int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    PriorityQueue<Integer> endTime = new PriorityQueue<>();
    int ans = 1;
    endTime.add(intervals[0][1]);
    for (int i = 1; i < intervals.length; i++) {
      while (intervals[i][0] > endTime.peek()) {
        endTime.remove();
      }
      endTime.add(intervals[i][1]);
      ans = Math.max(ans, endTime.size());
    }
    return ans;
  }
}
