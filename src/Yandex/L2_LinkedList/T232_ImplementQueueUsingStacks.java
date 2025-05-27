package Tasks.LeetCode.Yandex.L2_LinkedList;
public class T232_ImplementQueueUsingStacks {
  static class MyQueue {
    class Node {
      int val;
      Node next;
      Node(int val, Node next) {
        this.val = val;
        this.next = next;
      }
    }
    Node queue;
    Node current;
    public MyQueue() {
    }
    public void push(int x) {
      if (queue == null) {
        queue = new Node(x, null);
        current = queue;
      } else {
        current.next = new Node(x, null);
        current = current.next;
      }
    }
    public int pop() {
      int x = queue.val;
      if (current == queue)
        current = current.next;
      queue = queue.next;
      return x;
    }

    public int peek() {
      return queue.val;
    }

    public boolean empty() {
      return queue == null;
    }
  }
  public static void main(String[] args) {

  }
}
