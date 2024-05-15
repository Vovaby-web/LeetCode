/*
 �������� ������������� ������ nums � ����� ����� val, ������� ��� ��������� val � nums.
 ������� ��������� ����� ���� �������. ����� ������� ���������� ���������, � nums �������
 �� ����� val.
 ���������� ���������� ��������� � nums, ������� �� ����� val.
 ����� �� �������, ��� ���������� ������� ���������:
  �������� ������ nums ���, ����� ������ k �������� nums ��������� ��������, �� ������ val.
  ��������� �������� nums �� �����, ��� � ������ nums.
 ������������ k.
 int[] nums = [...];               // ������� ������
 int val = ...;                    // ��������, ������� ��������� �������
 int[] expectedNums = = [...];     // ��������� ����� ���������� �����.
                                   // �� ������������ ��� ��������, ������ val.
 int k = RemoveElement(nums, val); // �������� ���� ����������
 assert k == expectedNums.length;
 ���������� (�����, 0, �);         // ��������� ������ k ��������� ����� nums
 for (int i = 0; i <expectedNums.length; i++)
   assert nums[i] == expectedNums[i];
 ���� ��� ����������� ��������, ���� ������� ����� �������
*/
package Lessons.LeetCode.TopInterview150.C1_ArrayString;

import java.util.Arrays;

public class T2_RemoveElement {
  // ����� ��� ���������� ����� val, ������� ���������� ������ � ������������ ���
  // ������� � ����� �������
  private static int removeElement(int[] nums, int val) {
    int limit = nums.length;                 // ��� ��������� �� ����� �������
    // ����� �� limit ����� ��� val, ������ ������ val
    for (int i = 0; i < limit; i++)          // ���� �� ������
      if (nums[i] == val) {                  // ���� ������� = val
        limit--;                             // C������ ���������, �.�. ����� ��������� [j+1]
        for (int j = i; j < limit; j++)      // �� i �� limit
          nums[j] = nums[j + 1];             // �������� ��� ������� val
        nums[nums.length - 1] = val;         // ��������� ��� ������� � ����� �������
        i--;                                 // ����� ������, ������� ��������� ���� ���������
      }
    return limit;                            // ���������� ����� ����������� �������
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 2, 3};               // Input array
    int val = 3;                             // Value to remove
    int[] expectedNums = {2, 2};             // The expected answer with correct length.
    int k = removeElement(nums, val);        // Calls your implementation
    assert k == expectedNums.length;         // ���� ���, �� ������ ����������
    Arrays.sort(nums, 0, k);       // Sort the first k elements of nums
    for (int i = 0; i < k; i++) {
      assert nums[i] == expectedNums[i];     // ���� ���, �� ������ ����������
    }
  }
}
