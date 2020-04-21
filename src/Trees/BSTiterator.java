package Trees;

/**
 * Design Binary Search Tree iterator in a such a way next() always give
 * the smallest value ,second smallest value and so on.
 **/


import java.util.*;


public class BSTiterator{
    static class Node{
        int data;
        Node left ;
        Node right;

        Node(int d)
        {
            data = d;
            left = null;
            right = null;
        }
    }
    Node root;

    Stack<Node> stack = new Stack<Node>();

    public void pushToAll(Node root)
    {
        pushToLeft(root);
    }

    public int next()
    {
        Node node = stack.pop();
        pushToLeft(node.right);
        return node.data;
    }

    public boolean hasNext()
    {
        return !stack.isEmpty();
    }

    public void pushToLeft(Node root)
    {
        if(root == null)
            return;

        stack.push(root);
        pushToLeft(root.left);
    }


    //Driver Program
    public static void main(String[] args)
    {
        BSTiterator tree = new BSTiterator();
        tree.root = new Node(7);
        tree.root.left = new Node(3);
        tree.root.right = new Node(15);
        tree.root.right.left = new Node(9);
        tree.root.right.right = new Node(20);

        tree.pushToAll(tree.root);

        while(tree.hasNext()){
            int res = tree.next();
            System.out.print(res +"      ");

        }
    }
}
