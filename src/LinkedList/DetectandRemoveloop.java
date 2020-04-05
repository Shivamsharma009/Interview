package LinkedList;

//Detect and Remove loop in a Linked List

public class DetectandRemoveloop{
    static Node head = null;

    static class Node {
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }



    Node push(int new_data)
    {
        Node temp = new Node(new_data);
        temp.next = head;
        head = temp;
        return temp;
    }
    int DetectandRemoveLoop(Node head)
    {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) //Detect loop
                break;
        }
        if(slow == fast)
        {
            slow = head;

            while(slow.next != fast.next)
            {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null; //Remove loop
            return 1;
        }
        return 0;
    }


    void printList(Node head)
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+"  ");
            temp = temp.next;
        }
    }


    //Driver Program
    public static void main(String[] args)
    {
        DetectandRemoveloop dr = new DetectandRemoveloop();
        head  = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = head.next.next;

        dr.DetectandRemoveLoop(head);
        dr.printList(head);

    }
}
