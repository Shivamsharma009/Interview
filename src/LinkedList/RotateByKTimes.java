package LinkedList;

//Rotate an Linked List by k times

public class RotateByKTimes{
    static Node head = null;

    static class Node{
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }


    void push(int new_data)
    {
        Node temp = new Node(new_data);
        temp.next = head;
        head = temp;
    }

    void printList(Node node)
    {
        Node temp = node;
        while(temp != null)
        {
            System.out.print(temp.data +"  ");
            temp = temp.next;
        }
    }

    Node rotatebyktimes(Node head,int k)
    {
        Node curr = head;
        int count;

        for(count = 1; count != k && curr != null ;count++)
            curr = curr.next;

        Node knode = curr;

        while(curr.next != null)
        {
            curr = curr.next;
        }

        curr.next = head;
        head = knode.next;
        knode.next = null;


        return head;
    }

    //Driver Program
    public static void main(String[] args)
    {
        int k = 4;
        int i;
        RotateByKTimes rk = new RotateByKTimes();
        for(i = 6;i > 0;i--)
            rk.push(i);
        System.out.println("Linked List Before Rotation by k times");
        rk.printList(head);

        head = rk.rotatebyktimes(head,k);

        System.out.println("\nLinked List after Rotation by k times");
        rk.printList(head);
    }
}
