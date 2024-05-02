// https://leetcode.com/problems/container-with-most-water/description/
package Yandex.L8_TwoPointers.T11;
public class T11_ContainerWater {
  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{8,3,5,7,4}));
  }
  // 1 ��
  public static int maxArea(int[] height) {
    // ����� �������
    int left = 0;
    // ������ �������
    int right = height.length - 1;
    // ��� ���������
    int result = 0;
    // ������ ����
    int h;
    while (left < right) {
      // ������ ���� ����� - ����������� �������
      h = Math.min(height[left], height[right]);
      // ���������� ���������� ��������� � ������� ���������
      result = Math.max(result, h * (right - left));
      // ���� ��������� ������� ����� ������ ����� ������, �� ������ ��������� ��� ���
      // ��������� � ���������� �������
      while (left < right && height[left] <= h)
        left++;
      // ���� ��������� ������� ������ ������ ����� ������, �� ������ ��������� ��� ���
      // ��������� � ���������� �������
      while (left < right && height[right] <= h)
        right--;
    }
    return result;
  }
}
