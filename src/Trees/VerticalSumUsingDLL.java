package Trees;

public class VerticalSumUsingDLL {
    static  class Node{
        int data;
        Node left , right = null;

        Node(int d)
        {
            data = d;
        }
    }

    static class headNode{
        int data;
        headNode prev ,next = null;

        headNode(int d)
        {
            data = d;
        }
    }

    static  Node root;
    static headNode head;

    //Function to print Vertical Order Traversal
    static  void printVerticalOrder(Node root)
    {
        //create Doubly Linked List
        head = new headNode(0);

        //function to maintain and sum the Dll
        verticalSum(root,head);

        //Traverse and print the vertical sum
        while(head.prev != null)
            head = head.prev;

        System.out.println("The Vertical Sum is ");
        while(head!=null)
        {

            System.out.print(head.data+"  ");
            head = head.next;
        }

    }

    static void verticalSum(Node root,headNode head)
    {
        //sum of vertical sum
        head.data = head.data + root.data;

        if(root.left != null)
        {
            if(head.prev == null)
            {
                head.prev = new headNode(0);
                head.prev.next = head;

            }
            verticalSum(root.left,head.prev);
        }

        if(root.right != null)
        {
            if(head.next == null)
            {
                head.next = new headNode(0);
                head.next.prev = head;
            }
            verticalSum(root.right,head.next);
        }
    }

    //Driver Program
    public static void main(String[] args)
    {
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(4);

        root.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        printVerticalOrder(root);
    }
}
