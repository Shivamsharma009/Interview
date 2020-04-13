package Trees;

public class SizeOfBinaryTree {

    static Node root;
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int d)
        {
            data = d;
            left = null;
            right = null;
        }
    }

    static int sizeofTree(Node root)
    {
        if(root != null)
            return 1 + sizeofTree(root.left) + sizeofTree(root.right);
        else
            return 0;
    }

    //Driver Program
    public static void main(String[] args)
    {
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Size of Binary Tree is " +sizeofTree(root));
    }
}
