package Trees;
import java.util.*;
public class LevelOrderTraversal {
    static Node root = null;

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

    static  void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(root.data+"  ");
            inorder(root.right);
        }
    }


    //Print Level Order
    static void getLevelOrder(Node root) {
        if (root == null) return;
        else {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                System.out.print(temp.data + "   ");

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }
    //Driver Program
    public static  void main(String[] args){
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The Level Order Traversal of a tree");
        getLevelOrder(root);
    }
}

