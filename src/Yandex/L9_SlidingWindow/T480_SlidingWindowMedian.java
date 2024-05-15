// https://leetcode.com/problems/sliding-window-median/description/
package Yandex.L9_SlidingWindow;
import java.util.*;
public class T480_SlidingWindowMedian {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(medianSlidingWindow(new int[]{5, 3, -1, 4, 2}, 3)));
  }
  /**
   * Using Priority Queue. (Here time complexity is not optimized)
   * Time Complexity: O((N-K)*K + N*log K).
   * Add Elements = O(N*Log K)
   * Remove Elements = O((N-K)*K) ==> PQ.remove() in JAVA is O(K)
   * <p>
   * Space Complexity: O(K)
   * <p>
   * N = Length of nums array. K = Input k.
   */
  public static double[] medianSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    double[] result = new double[n - k + 1];
    if (k == 1)  return Arrays.stream(nums).asDoubleStream().toArray();
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      if (i >= k) {
        remove(left, right, nums[i - k]);
      }
      addElem(left, right, nums[i]);
      if (i >= k - 1) {
        result[i - (k - 1)] = median(left, right);
      }
    }
    return result;
  }
  private static void addElem(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int n) {
    left.offer(n);
    right.offer(left.poll());
    if (left.size() < right.size()) {
      left.offer(right.poll());
    }
  }
  private static void remove(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int n) {
    if (n >= right.peek()) {
      right.remove(n);
      if (left.size() == right.size() + 2) {
        right.offer(left.poll());
      }
    } else {
      left.remove(n);
      if (left.size() < right.size()) {
        left.offer(right.poll());
      }
    }
  }
  private static double median(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
    if (left.size() == right.size()) {
      return ((double) left.peek() + right.peek()) / 2.0;
    }
    return left.peek();
  }

  // ��������� O(n log k)
  public static double[] medianSlidingWindow3(int[] nums, int k) {
    int n = nums.length;
    int j = 0;
    double[] result = new double[n - k + 1];
    List<Integer> list = new ArrayList<>();
    // ���������� ������ k-1 ���������
    for (int i = 0; i < k - 1; i++)
      list.add(nums[i]);
    // ���������, �.�. ��� ���� ��������������� ������ ��� ���������� �������
    Collections.sort(list);
    for (int i = k - 1; i < n; i++) {
      // �������� �����, ���� ������� ��� ������������ � ������ ������� ���� ���������� ������,
      // ����� ��� ���������� - (��������� ������� +1), ��, ��� ������������� ����
      int r = Collections.binarySearch(list, nums[i]);
      if (r > -1)
        list.add(r + 1, nums[i]); // �������� ����� � ���
      else list.add(Math.abs(r + 1), nums[i]); // �������� ��� � ��������� ���������
      // �������� � ������ result ������� �������� �������� k
      if (k % 2 == 0) {
        result[i - k + 1] = ((double) list.get((k / 2) - 1) + list.get((k / 2))) / 2.0;
      } else {
        result[i - k + 1] = list.get((k / 2));
      }
      // ����� ���� ���������� �� ���� �������, �� ������ ������� ��� �������
      // � ��������������� ������ � ������� ���
      int l = Collections.binarySearch(list, nums[j]);
      list.remove(l);
      j++;
    }
    return result;
  }
  public static double[] medianSlidingWindow1(int[] nums, int k) {
    List<Double> medians = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    // max ����
    PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    // min ����
    PriorityQueue<Integer> right = new PriorityQueue<>();
    int i = 0; // ������ �������� ��������������� ��������� ��������
    while (i < k) {
      left.offer(nums[i++]);
    }
    for (int j = 0; j < k / 2; j++) {
      right.offer(left.poll());
    }
    while (true) {
      // �������� ������� �������� ����
      medians.add(k % 2 == 1 ?
        (double) left.peek() : ((double) left.peek() + (double) right.peek()) * 0.5);
      if (i >= nums.length)
        break; // �������, ���� ���������� ��� ��������
      int outNum = nums[i - k]; // ��������� �������
      int inNum = nums[i++]; // �������� �������
      int balance = 0; // balance factor
      // ����� `outNum` ������� �� ����
      balance += (outNum <= left.peek() ? -1 : 1);
      map.put(outNum, map.getOrDefault(outNum, 0) + 1);
      // ����� `inNum` ������ � ����
      if (!left.isEmpty() && inNum <= left.peek()) {
        balance++;
        left.offer(inNum);
      } else {
        balance--;
        right.offer(inNum);
      }
      if (balance < 0) { // `lo` ����� ������ ���������� ���������
        left.offer(right.poll());
        balance++;
      }
      if (balance > 0) { // `hi` ������� ������ ���������� ���������
        right.offer(left.poll());
        balance--;
      }
      // ������� ������������ �����, ������� ������� ��������� �� ������ ����
      while (map.getOrDefault(left.peek(), 0) > 0) {
        map.put(left.peek(), map.get(left.peek()) - 1);
        left.poll();
      }
      while (!right.isEmpty() && map.getOrDefault(right.peek(), 0) > 0) {
        map.put(right.peek(), map.get(right.peek()) - 1);
        right.poll();
      }
    }
    double[] result = new double[medians.size()];
    for (int j = 0; j < medians.size(); j++) {
      result[j] = medians.get(j);
    }
    return result;
  }
  /**
   * Using TreeSet. (Here time complexity is most optimized)
   * <p>
   * Very similar to https://leetcode.com/problems/find-median-from-data-stream/
   * <p>
   * Time Complexity: O((N-K)*log K + N*log K) = O(N * log K)
   * Add Elements = O(N*Log K)
   * Remove Elements = O((N-K)*log K) ==> TreeSet.remove() in JAVA is O(log K)
   * <p>
   * Space Complexity: O(K)
   * <p>
   * N = Length of nums array. K = Input k.
   */
  // ������������ ��� TreeSet ��� �������� �������� ��������� � ������� nums.
  // ��� ��������� ���������� �������� ������� � ���������� ���� �������� k.
  // ������������� ���� TreeSet ��������� ������ �������� ������� � ���������� ����
  // ��� ������������� ���������� ����� ���� �� ������ ����.
  // ������ ����� ������� ����������� �� ������ ���� TreeSet, ������� ������ �������� �������
  // ������������ � ����������� �������� � ����.
  public static double[] medianSlidingWindow2(int[] nums, int k) {
    int n = nums.length;
    double[] result = new double[n - k + 1];
    if (k == 1)
      return Arrays.stream(nums).asDoubleStream().toArray();
    Comparator<Integer> comparator =
      (a, b) -> (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b));
    // ���� TreeSet (leftNums) ������ ������� ���������, ������� ��������� �����
    // �� �������� �������� � ������ ���.
    TreeSet<Integer> leftNums = new TreeSet<>(comparator.reversed());
    // ������ TreeSet (rightNums) ������ ������� ���������, ������� ��������� ������
    // �� �������� �������� � ������ ���.
    TreeSet<Integer> rightNums = new TreeSet<>(comparator);
    for (int i = 0; i < n; i++) {
      if (i >= k) {
        removeElement(leftNums, rightNums, nums, i - k);
      }
      addIndex(leftNums, rightNums, i, nums);
      if (i >= k - 1) {
        result[i - k + 1] = getMedian(leftNums, rightNums, nums);
      }
    }
    return result;
  }
  // ��� ���������� ������ �������� � ����, �� ������� ����������� � smallNums, ����� ��������������
  // � largeNums, ���� ��� ���������� ��� ���������� ������� �������� ���� TreeSet.
  // [5,2,2,7,3,7,9,0,2,3]
  // 9
  private static void addIndex(TreeSet<Integer> leftNums, TreeSet<Integer> rightNums, int i, int[] nums) {
    leftNums.add(i);
    rightNums.add(leftNums.pollFirst());
    if (leftNums.size() < rightNums.size()) {
      leftNums.add(rightNums.pollFirst());
    }
  }
  // ��� �������� �������� �� ����, ��������������� ������ ��������� �� ������ �� TreeSet.
  private static void removeElement(TreeSet<Integer> leftNums, TreeSet<Integer> rightNums,
                                    int[] nums, int i) {
    if (rightNums.contains(i)) {
      rightNums.remove(i);
      if (leftNums.size() == rightNums.size() + 2) {
        rightNums.add(leftNums.pollFirst());
      }
    } else {
      leftNums.remove(i);
      if (leftNums.size() < rightNums.size()) {
        leftNums.add(rightNums.pollFirst());
      }
    }
  }
  private static double getMedian(TreeSet<Integer> smallNums, TreeSet<Integer> largeNums, int[] nums) {
    if (smallNums.size() == largeNums.size()) {
      return ((double) nums[smallNums.first()] + nums[largeNums.first()]) / 2;
    }
    return nums[smallNums.first()];
  }
}
