package LinkedList;

//Alternating split in a given Linked List

public class AlternateSplit{
    static Node head = null;

    static class Node{
        int data ;
        Node next;

        Node(int d){
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

    void printList(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+ "  ");
            temp = temp.next;
        }
    }

    private Node[] AlternateSplit(Node head)
    {
        Node[] node = new Node[2];
        node[0] = head;
        node[1] =  head.next;
        Node p = head;
        Node temp;

        while(p != null)
        {
            temp = p.next;
            p.next = temp!=null?temp.next:temp;
            p = temp;
        }
        return node;
    }


    //Driver Program

    public static void main(String[] args)
    {
        AlternateSplit as = new AlternateSplit();
        for(int i = 5; i > 0;i--)
        {
            as.push(i);
        }

        Node[] node = as.AlternateSplit(head);
        Node head1 = node[0];
        Node head2 = node[1];
        System.out.println("Linked List 1 Alternate Order");
        as.printList(head1);
        System.out.println("\nLinked List 2 Alternate Order");
        as.printList(head2);
    }
}
