
package  Trees;

class LowestCommonAncestorBT
{
    static class Node{

        int data;
        Node left,right;

        Node(int item)
        {
            data = item;
            Node left,right = null;
        }
    }

    static  Node root;

    static Node LCABinaryTree(Node root,int p ,int q)
    {
        if(root == null) return null;
        if(root.data == p ||root.data == q)
            return root;

        Node left = LCABinaryTree(root.left,p,q);
        Node right = LCABinaryTree(root.right,p,q);

        if(left!=null && right!=null)
            return root;
        else
            return (left!=null)?left:right;
    }


    //Driver Program
    public static  void main(String[] args)
    {
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node res = LCABinaryTree(root,4,5);
        System.out.println("Lowest Common Ancestor of Binary Tree is = "+res.data);
    }
}