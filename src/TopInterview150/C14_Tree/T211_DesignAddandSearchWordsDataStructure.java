// https://leetcode.com/problems/design-add-and-search-words-data-structure/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C14_Tree;
public class T211_DesignAddandSearchWordsDataStructure {
  static class WordDictionary {
    class Node {
      private boolean word;
      private Node next[] = new Node[27];
    }
    Node root;
    public WordDictionary() {
      root = new Node();
    }
    public void addWord(String word) {
      Node curr = root;
      for (int i = 0; i < word.length(); i++) {
        int c = word.charAt(i) - 'a';
        if (curr.next[c] == null) {
          curr.next[c] = new Node();
        }
        curr = curr.next[c];
      }
      curr.word = true;
    }
    public boolean search(String word) {
      return searchInNode(word, root, 0);
    }
    public boolean searchInNode(String word, Node root, int start) {
      Node curr = root;
      for (int i = start; i < word.length(); i++) {
        int index = word.charAt(i) - 'a';
        if (word.charAt(i) == '.') {
          for (Node x : curr.next) {
            if (x != null && searchInNode(word, x, i + 1))
              return true;
          }
          return false;
        } else {
          if (curr.next[index] == null)
            return false;
          curr = curr.next[index];
        }
      }
      return curr.word;
    }
  }
  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    wordDictionary.search("pad");
    wordDictionary.search("bad");
    wordDictionary.search(".ad");
    wordDictionary.search("b..");
  /*  wordDictionary.addWord("a");
    wordDictionary.addWord("a");
    System.out.println(wordDictionary.search("."));
    System.out.println(wordDictionary.search("a"));
    System.out.println(wordDictionary.search("aa"));
    System.out.println(wordDictionary.search("a"));
    System.out.println(wordDictionary.search(".a"));
    System.out.println(wordDictionary.search("a."));*/
  }
}
