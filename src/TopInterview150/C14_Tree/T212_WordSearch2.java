// https://leetcode.com/problems/word-search-ii/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C14_Tree;
import java.util.*;
public class T212_WordSearch2 {
  public static void main(String[] args) {
    System.out.println(findWords(new char[][]{
       {'o','a','a','n'},
       {'e','t','a','e'},
       {'i','h', 'k','r'},
       {'i','f','l','v'}},
       new String[]{"oath","pea","eat","rain"}));
  }
  static class Node {
    Node[] next = new Node[26];
    String word;
  }
  public static List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    Node root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs (board, i, j, root, res);
      }
    }
    return res;
  }
  public static Node buildTrie(String[] words) {
    Node root = new Node();
    for (String w : words) {
      Node node = root;
      for (char c : w.toCharArray()) {
        int i = c - 'a';
        if (node.next[i] == null)
          node.next[i] = new Node();
        node = node.next[i];
      }
      node.word = w;
    }
    return root;
  }
  public static void dfs(char[][] board, int i, int j, Node node, List<String> res) {
    char c = board[i][j];
    if (c == '#' || node.next[c - 'a'] == null)
      return;
    node = node.next[c - 'a'];
    if (node.word != null) {
      res.add(node.word);
      node.word = null;
    }
    board[i][j] = '#';
    if (i > 0)
      dfs(board, i - 1, j ,node, res);
    if (j > 0)
      dfs(board, i, j - 1, node, res);
    if (i < board.length - 1)
      dfs(board, i + 1, j, node, res);
    if (j < board[0].length - 1)
      dfs(board, i, j + 1, node, res);
    board[i][j] = c;
  }
}
