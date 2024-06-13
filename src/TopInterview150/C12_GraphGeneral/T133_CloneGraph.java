// https://leetcode.com/problems/clone-graph/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C12_GraphGeneral;
import java.util.*;
public class T133_CloneGraph {
  static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
  public static void main(String[] args) {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    one.neighbors.add(two);
    one.neighbors.add(four);
    two.neighbors.add(one);
    two.neighbors.add(three);
    three.neighbors.add(two);
    three.neighbors.add(four);
    four.neighbors.add(one);
    four.neighbors.add(three);
    System.out.println(cloneGraph(one));
  }
  static Map<Node, Node> m = new HashMap<>();
  public static Node cloneGraph(Node node) {
    return dfs(node);
  }
  public static Node dfs(Node node) {
    if (node == null)
      return null;
    if (m.containsKey(node))
      return m.get(node);
    Node copy = new Node(node.val);
    m.put(node, copy);
    for (Node x : node.neighbors) {
      copy.neighbors.add(dfs(x));
    }
    return copy;
  }
}
