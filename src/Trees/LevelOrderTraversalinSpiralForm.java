package Trees;

import java.util.Stack;

public class LevelOrderTraversalinSpiralForm {

    static class Node
    {
        int data;
        Node left,right = null;

        Node(int d)
        {
            data = d;
        }
    }

    static Node root;

    static  void LevelOrderSpiral(Node root)
    {
        if(root == null)
          return;

        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        s1.push(root);

        while(!s1.empty() || !s2.empty())
        {
            while(!s1.empty())
            {
                Node curr_node = s1.peek();
                s1.pop();

                System.out.print(curr_node.data+"   ");

                if(curr_node.right!=null)
                    s2.push(curr_node.right);
                if(curr_node.left!=null)
                    s2.push(curr_node.left);
            }

            while(!s2.empty())
            {
                Node curr_node = s2.peek();
                s2.pop();

                System.out.print(curr_node.data+"  ");
                if(curr_node.left!=null)
                    s1.push(curr_node.left);
                if(curr_node.right!=null)
                    s1.push(curr_node.right);
            }
        }
    }

    //Driver Program
    public static  void main(String[] args)
    {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.right.right = new Node(9);

        LevelOrderSpiral(root);
    }

}
