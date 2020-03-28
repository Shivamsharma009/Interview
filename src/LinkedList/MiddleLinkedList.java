package LinkedList;
//Java Program to find Middle Node of a Linked List
public class MiddleLinkedList{
   private static  Node head;
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private Node FindMiddleNode(Node node) {
        Node fast =node;
        Node slow = node;
        while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
        return slow;
    }

    private void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "  ");
            node = node.next;
        }
    }

    //Driver Program
    public static void main(String[] args) {
        MiddleLinkedList  list = new MiddleLinkedList ();
        list.head = new Node(5);
        list.head.next = new Node(6);
        list.head.next.next = new Node(7);
        list.head.next.next.next = new Node(8);
        System.out.println("Given Linked List");
        list.printList(head);
        System.out.print("\nMiddle Element is");
        Node res = list.FindMiddleNode(head);
        System.out.print(" \n" +res.data);
    }
}
