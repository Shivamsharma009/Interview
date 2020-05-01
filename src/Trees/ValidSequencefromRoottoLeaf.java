package Trees;

import java.util.ArrayList;

public class ValidSequencefromRoottoLeaf {

    static class Node{
        int data;
        Node left = null;
        Node right = null;

        Node(int d)
        {
            data = d;
        }
    }
    static  Node root;

    private static boolean isValidSequence(Node root, int n, int pos, int[] arr) {
        if (root == null)
            return false;
        else if (pos == n)
            return false;
        else if (root.data != arr[pos])
            return false;
        else if (root.left == null && root.right == null && pos == n - 1)
            return true;

        return (isValidSequence(root.left, n, pos + 1, arr) || isValidSequence(root.right, n, pos + 1, arr));
    }

    //Driver Program
    public static void main(String[] args)
    {
        int[] arr = new int[]{1,0,1};
        int n = arr.length;
        int pos = 0;
        root = new Node(1);
        root.left = new Node(0);
        root.left.left = new Node(0);
        root.left.right = new Node(1);
        root.left.right.left = new Node(0);

        root.right = new Node(0);
        root.right.left = new Node(1);

        boolean res = isValidSequence(root,n,pos,arr);
        if(res)
            System.out.print("True");
        else
            System.out.print("False");
    }

}
