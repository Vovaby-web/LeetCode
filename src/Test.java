import java.util.*;
public class Test {
  static class Node {
    String word;
    Map<Integer,Node> next=new HashMap<>();
  }
  public static void main(String[] args) {
    System.out.println(findWords(new char[][]{
          {'o','a','a','n'},
          {'e','t','a','e'},
          {'i','h', 'k','r'},
          {'i','f','l','v'}},
       new String[]{"oath","pea","eat","rain"}));
  }

  static Node root=new Node();
  static List<String> ans=new ArrayList<>();
  public static List<String> findWords(char[][] board, String[] words) {
    for(String s:words){
      Node node=root;
      for (char c:s.toCharArray()){
        int i=c-'a';
        if (node.next.get(i)==null)
          node.next.put(i,new Node());
        node=node.next.get(i);
      }
      node.word=s;
    }
    for (int i=0;i<board.length;i++){
      for (int j=0;j<board[0].length;j++){
        dfs(board,root,i,j);
      }
    }
    return ans;
  }
  public static void dfs(char[][] board, Node node, int i, int j) {
    char c=board[i][j];
    if (node.next.get(c-'a')==null||board[i][j]=='#')
      return;
    node=node.next.get(c-'a');
    if (node.word!=null){
      ans.add(node.word);
      node.word=null;
    }
    board[i][j]='#';
    if (i>0)
      dfs(board, node, i-1, j);
    if (j>0)
      dfs(board, node, i, j-1);
    if (i<board.length-1)
      dfs(board, node, i+1, j);
    if (j<board[i].length-1)
      dfs(board, node, i, j+1);
    board[i][j]=c;
  }
}
