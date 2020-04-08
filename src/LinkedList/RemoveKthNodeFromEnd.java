package LinkedList;

//Java Program to Remove K Node from  End in Link List

public class RemoveKthNodeFromEnd {
    static Node head = null;

    static  class Node{
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    //Insert data into a link list
  private static   Node InsertIntoLinkList(Node head, int new_data)
    {
        Node ptr;
       Node temp = new Node(new_data);
       if(head == null) {
           head = temp;
           return head;
       }
       else {
           ptr = head;
           while (ptr.next != null) {
               ptr = ptr.next;
           }
           ptr.next = temp;
       }
           return head;
    }

    static  void printList(Node node)
    {
        Node temp = node;
        while(temp!=null)
        {
            System.out.print(temp.data+"   ");
            temp = temp.next;
        }
    }


    //Remove K node from End
     private static Node removeknodefromend(Node head, int k)
    {
        int len = 0;
        Node temp = head;
        while(temp!=null) {
            len++;
            temp = temp.next;
        }

        if(k > len){
            System.out.println("Not possible");
            return  head;
        }else if(k == len){
            return head.next;
        }else{
            int diff = len - k;
            Node prev = null;
            Node curr = head;
            for(int i = 0 ;i < diff ;i++)
            {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            return head;
        }
    }

    //Driver Program
    public static  void main(String[] args)
    {
        head = InsertIntoLinkList(head,1);
        head = InsertIntoLinkList(head,2);
        head = InsertIntoLinkList(head,3);
        head = InsertIntoLinkList(head,4);
        head = InsertIntoLinkList(head,5);
        head = InsertIntoLinkList(head,6);

        System.out.println("Linked List Before Modification");
        printList(head);


        head = removeknodefromend(head,3);
        System.out.println("\nLinked List After Modification");
        printList(head);










    }
}
