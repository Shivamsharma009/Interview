package Trees;

public class VerticalOrderUsingDoublyLinkedList {
    static class Node{
        int data;
        Node left , right = null;

        Node(int d)
        {
            data = d;
        }
    }
    static class headNode{
        int hd;
        Entry list;
        headNode left ,right = null;

        headNode(int d)
        {
            hd = d;
        }
    }

    static class Entry{
        int data;
        Entry next;

        Entry(int d)
        {
            data = d;
        }
    }
    static Node root;
    static  headNode head;

   static void BuildDoublyLinkedList(Node root,headNode head)
    {
        if(root == null)
            return;
        Entry e = new Entry(root.data);
        e.next = head.list;
        head.list = e;

        if(root.left != null)
        {
            if(head.left == null)
            {
                head.left = new headNode(head.hd-1);
                head.left.right = head;
            }
            BuildDoublyLinkedList(root.left,head.left);
        }

        if(root.right != null)
        {
            if(head.right == null)
            {
                head.right = new headNode(head.hd+1);
                head.right.left = head;

            }
            BuildDoublyLinkedList(root.right,head.right);
        }
    }

    static void printVerticalOrder(headNode head) {
        while (head.left != null) {

            head = head.left;
        }
        while (head.right != null) {
            Entry list_clone = head.left.list;
            while (list_clone.next != null) {
                System.out.print(list_clone.data + "  ");
                list_clone = list_clone.next;
            }
            head = head.right;
        }
    }

    //Driver Program
    public static void main(String[] args)
    {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        head = new headNode(0);

        BuildDoublyLinkedList(root,head);
        printVerticalOrder(head);
    }
}
