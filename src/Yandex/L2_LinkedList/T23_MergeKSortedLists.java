package Tasks.LeetCode.Yandex.L2_LinkedList;
import java.util.Arrays;
import java.util.PriorityQueue;
public class T23_MergeKSortedLists {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
      this.val = val;
    }
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
  public static void main(String[] args) {
    ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
    ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode node3 = new ListNode(2, new ListNode(6));
    System.out.println(mergeKLists(new ListNode[]{node1, node2, node3}));
  }
  public static ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode node : lists) {
      if (node != null)
        pq.offer(node);
    }
    ListNode ans = pq.poll();
    if (ans != null && ans.next != null)
      pq.offer(ans.next);
    ListNode current = ans;
    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      if (node.next != null)
        pq.offer(node.next);
      current.next = node;
      current = current.next;
    }
    return ans;
  }
}
