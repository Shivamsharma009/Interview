package LinkedList;

//Java Program on Flatten an Linked List

public class FlattenLinkList{
    static Node head = null;

    class Node{
        int data;
        Node right;
        Node down;

        Node(int d)
        {
            data = d;
            right = null;
            down = null;
        }
    }

    void printList(Node node)
    {
        Node temp = node;
        while(temp != null)
        {
            System.out.print(temp.data +"  ");
            temp = temp.down;
        }
    }

   Node push(Node head,int new_data)
    {
        Node temp = new Node(new_data);
        temp.down= head;
        head = temp;

        return head;

    }


    Node merge(Node a ,Node b)
    {
        if(a == null)
            return b;

        if(b == null)
            return a;

        Node result;

        if(a.data < b.data)
        {
            result = a;
            result.down = merge(a.down,b);
        }
        else
        {
            result = b;
            result.down = merge(a,b.down);
        }
        return result;
    }


    Node flatten(Node head)
    {
        if(head == null || head.right == null)
            return head;

        return merge(head , flatten(head.right));
    }



    //Driver Program
    public static void main(String[] args) {
        FlattenLinkList fll = new FlattenLinkList();

        head = fll.push(head,30);
        head = fll.push(head,8);
        head = fll.push(head,7);
        head = fll.push(head,5);

        head.right = fll.push(head.right,20);
        head.right = fll.push(head.right,10);

        head.right.right = fll.push(head.right.right ,50);
        head.right.right = fll.push(head.right.right,22);
        head.right.right = fll.push(head.right.right,19);


        head.right.right.right = fll.push(head.right.right.right,45);
        head.right.right.right = fll.push(head.right.right.right,40);
        head.right.right.right = fll.push(head.right.right.right,35);
        head.right.right.right = fll.push(head.right.right.right,28);


        head = fll.flatten(head);
        System.out.println("Linked List After Flatten");
        fll.printList(head);



    }
}
