package LinkedList;

public class Detectloop {
    static Node head;
    static  class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    int detectLoopinLL(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null && slow != null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                return 1;
        }
        return  -1;
    }


    //Driver Program
    public static void main(String[] args){
        Detectloop dl = new Detectloop();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next =head.next;

        int data = dl.detectLoopinLL(head);
        if(data > 0)
            System.out.println("Linked List has loop");
        else
            System.out.println("Linked List not Contain Loop");
    }
}
