package Tasks.LeetCode.Yandex.L2_LinkedList;
import java.util.*;
public class T146_LRUCache {
  public static class LRUCache1 {
    private final Map<Integer, Integer> map;
    public LRUCache1(int capacity) {
      map = new LinkedHashMap<>(16, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry element) {
          return size() > capacity;
        }
      };
    }
    public int get(int key) {
      if (!map.containsKey(key)) {
        return -1;
      }
      return map.get(key);
    }
    public void put(int key, int value) {
      map.put(key, value);
    }
  }
  static class LRUCache {
    static class Node {
      int key;
      int val;
      Node prev;
      Node next;
      Node() {
      }
      Node(int key, int val) {
        this.key = key;
        this.val = val;
      }
    }
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;
    // После инициализации изменить нельзя
    private final int capacity;
    public LRUCache(int capacity) {
      // Инициализация переменной capacity
      this.capacity = capacity;
      cache = new HashMap<>();
      head = new Node();
      tail = new Node();
      head.next = tail;
      tail.prev = head;
    }
    public int get(int key) {
      if (!cache.containsKey(key)) {
        return -1;
      }
      Node node = cache.get(key);
      removeNode(node);
      addToHead(node);
      return node.val;
    }
    public void put(int key, int value) {
      if (cache.containsKey(key)) {
        Node node = cache.get(key);
        node.val = value;
        removeNode(node);
        addToHead(node);
      } else {
        Node node = new Node(key, value);
        cache.put(key, node);
        addToHead(node);
        if (cache.size() > capacity) {
          node = removeTail();
          cache.remove(node.key);
        }
      }
    }
    private void addToHead(Node node) {
      node.next = head.next;
      node.prev = head;
      head.next = node;
      node.next.prev = node;
    }
    private Node removeTail() {
      Node node = tail.prev;
      removeNode(node);
      return node;
    }
    private void removeNode(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
  }
  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    System.out.println(cache.get(1));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));
  }
}
