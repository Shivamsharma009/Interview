package Trees;

import java.util.Stack;

//Java Program to pathSum LeetCode problem
public class PathSum {

    static  class Node{
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
    //Global variable
    Node root;

    public boolean hasPathSum(Node root,int sum) {
        //if root is null return false

        if (root == null)
            return false;

        Stack<Node> node_stack = new Stack<Node>();
        Stack<Integer> sum_stack = new Stack<Integer>();

        node_stack.add(root);
        sum_stack.add(sum - root.data);

        while (!node_stack.isEmpty()) {
            Node curr_node = node_stack.pop();
            int curr_sum = sum_stack.pop();

            if (curr_node.left == null && curr_node.right == null && curr_sum == 0)
                return true;

            if (curr_node.left != null) {
                node_stack.add(curr_node.left);
                sum_stack.add(curr_sum - curr_node.left.data);
            }


            if (curr_node.right != null) {
                node_stack.add(curr_node.right);
                sum_stack.add(curr_sum - curr_node.right.data);
            }
        }
        return false;
    }

        //Driver Program
        public static void main(String[] args)
        {
            int sum = 22;
            PathSum tree = new PathSum();
            tree.root = new Node(5);
            tree.root.left = new Node(4);
            tree.root.right = new Node(8);
            tree.root.left.left = new Node(11);
            tree.root.left.left.left = new Node(7);
            tree.root.left.left.right = new Node(2);

            tree.root.right.right = new Node(4);
            tree.root.right.left = new Node(13);
            tree.root.right.right.right = new Node(1);

            boolean res = tree.hasPathSum(tree.root,sum);
            if(res)
                System.out.println("The Tree Contain the path sum");
            else
                System.out.println("The Tree does not Contain Path Sum");

        }
    }

