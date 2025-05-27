package Tasks.LeetCode.Yandex.L2_LinkedList;
public class T155_MinStack{
  static class MinStack {
    class Node{
      int val;
      int min;
      Node next;
      private Node(int val,int min,Node next){
        this.val=val;
        this.min=min;
        this.next=next;
      }
    }
    public MinStack() {
    }
    private Node head;
    public void push(int val) {
      if(head==null){
        head=new Node(val,val,null);
      }else{
        head=new Node(val,Math.min(head.min,val),head);
      }
    }
    public void pop() {
      head=head.next;
    }
    public int top() {
      return head.val;
    }
    public int getMin() {
      return head.min;
    }
  }
  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(5);
    minStack.push(1);
    minStack.push(3);
    System.out.println(minStack.getMin());
  }
}
