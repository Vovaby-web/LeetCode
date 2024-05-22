// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C1_ArrayString;
public class T28_FindtheIndexoftheFirstOccurrence {
  public static void main(String[] args) {
    System.out.println(strStr("sadbutsad","sad"));
  }
  public static int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
  }
}
