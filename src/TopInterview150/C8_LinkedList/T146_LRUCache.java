// https://leetcode.com/problems/lru-cache/description/?envType=study-plan-v2&envId=top-interview-150
package TopInterview150.C8_LinkedList;
import java.util.*;
public class T146_LRUCache {
  static class Node {
    int k;
    int v;
    Node pre;
    Node next;
    Node() {
    }
    Node(int k, int v) {
      this.k = k;
      this.v = v;
    }
  }
  static class LRUCache {

    int capacity;
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> map = new HashMap<>();
    int size;
    public LRUCache(int capacity) {
      this.capacity = capacity;
      head.next = tail;
      tail.pre = head;
    }
    public int get(int key) {
      if (!map.containsKey(key)) {
        return -1;
      }
      Node node = map.get(key);
      node.pre.next = node.next;
      node.next.pre = node.pre;
      addHead(node);
      return node.v;
    }
    public void put(int key, int value) {
      if (map.containsKey(key)) {
        Node node = map.get(key);
        node.v = value;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addHead(node);
      } else {
        Node node = new Node(key, value);
        map.put(key, node);
        addHead(node);
        size++;
        if (size > capacity) {
          node = removeTail();
          map.remove(node.k);
          size--;
        }
      }
    }
    private void addHead(Node node) {
      node.next = head.next;
      node.pre = head;
      head.next = node;
      node.next.pre = node;
    }
    private Node removeTail() {
      Node node = tail.pre;
      node.pre.next = node.next;
      node.next.pre = node.pre;
      return node;
    }
  }
}
