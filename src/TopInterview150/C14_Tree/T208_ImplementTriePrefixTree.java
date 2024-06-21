// https://leetcode.com/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C14_Tree;
public class T208_ImplementTriePrefixTree {
  static class Trie {
    class Node {
      public boolean word;
      public Node[] next = new Node[26];
    }
    private Node root;
    public Trie() {
      root = new Node();
    }
    public void insert(String word) {
      Node node = root;
      for (char c : word.toCharArray()) {
        if (node.next[c - 'a'] == null)
          node.next[c - 'a'] = new Node();
        node = node.next[c - 'a'];
      }
      node.word = true;
    }
    public boolean search(String word) {
      Node node = root;
      for (char c : word.toCharArray()) {
        if (node.next[c - 'a'] == null)
          return false;
        node = node.next[c - 'a'];
      }
      return node.word;
    }
    public boolean startsWith(String prefix) {
      Node node = root;
      for (char c : prefix.toCharArray()) {
        if (node.next[c - 'a'] == null)
          return false;
        node = node.next[c - 'a'];
      }
      return true;
    }
  }
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.insert("apec");
    System.out.println(trie.search("apple"));
    System.out.println(trie.search("apc"));
    System.out.println(trie.startsWith("app"));
    trie.insert("app");
    System.out.println(trie.search("app"));
  }
}
