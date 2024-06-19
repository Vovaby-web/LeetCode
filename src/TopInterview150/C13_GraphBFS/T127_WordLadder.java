package TopInterview150.C13_GraphBFS;
import java.util.*;
public class T127_WordLadder {
  public static void main(String[] args) {
    System.out.println(ladderLength("hit", "cog",
       new ArrayList<>(List.of("hot", "him","dot", "dog", "lot", "log", "cog"))));
  }
  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0)
      return -1;
    Set<String> words = new HashSet<>(wordList);
    if (!words.contains(endWord))
      return 0;
    Queue<String> q = new LinkedList<>();
    int step = 1;
    q.offer(beginWord);
    while (!q.isEmpty()) {
      for (int i = q.size(); i > 0; i--) {
        String s = q.poll();
        char[] c = s.toCharArray();
        for (int j = 0; j < c.length; j++) {
          char old = c[j];
          for (char k = 'a'; k <= 'z'; k++) {
            c[j] = k;
            String newWord = String.valueOf(c);
            if (newWord.equals(endWord)) {
              return step + 1;
            }
            if (words.contains(newWord)) {
              q.add(newWord);
              words.remove(newWord);
            }
          }
          c[j] = old;
        }
      }
      step++;
    }
    return 0;
  }
}
