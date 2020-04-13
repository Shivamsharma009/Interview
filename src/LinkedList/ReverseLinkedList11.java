package LinkedList;

public class ReverseLinkedList11 {

    static Node head = null;
    static class Node {
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }

    static void push(int new_data)
    {
        Node temp = new Node(new_data);
        temp.next = head;
        head = temp;
    }

    static void printList(Node node)
    {
        Node temp = node;
        while(temp!=null)
        {
            System.out.print(temp.data+"   ");
            temp = temp.next;
        }
    }


    static Node reverselist11(Node head,int m ,int n)
    {
        if(head == null)
            return null;
        Node prev = null;
        Node curr = head;
        while(m > 1)
        {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }
        Node conn = prev;
        Node tail = curr;

        while(n > 0)
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }

        if(conn != null)
            conn.next = prev;
        else
            head = prev;

        tail.next = curr;

        return conn;
    }

    //Driver Program
    public static void main(String[] args)
    {
        for(int i = 5 ;i > 0 ;i--)
            push(i);

        System.out.println("Linked List Before Modification");
        printList(head);
        head = reverselist11(head,2,4);
        System.out.println("\n Linked List After Modification");
        printList(head);
    }
}
