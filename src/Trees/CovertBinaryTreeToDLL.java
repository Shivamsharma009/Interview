package Trees;

/**
 *            Problem statement
 * Convert a Binary Tree into Doubly Linked List in-place in such a way at the order of nodes
 * in doubly linked list represents the in-order traversal of binary tree.
 */
public class CovertBinaryTreeToDLL {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }
     Node root;
     Node head;
     static Node prev = null;

    void printList(Node node)
    {
        while(node!=null)
        {
            System.out.print(node.data+"    ");
            node = node.right;
        }
    }


    void  ConvertBTTODLL(Node root)
    {
        if(root == null)
            return;

        ConvertBTTODLL(root.left);
        if(prev == null) {
            head = root;
        }
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        ConvertBTTODLL(root.right);

    }

    //Driver Program
    public static void main(String[] args)
    {
        CovertBinaryTreeToDLL tree = new CovertBinaryTreeToDLL();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right = new Node(3);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.ConvertBTTODLL(tree.root);
        tree.printList(tree.head);
    }
}
