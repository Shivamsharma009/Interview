package Trees;

public class RecoverBST {
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
    Node root;
    Node startPoint,lastPoint = null;
    Node prev = null;

    public void recoverTree(Node root)
    {
        findSegment(root);
        //swap them
        int x = startPoint.data;
        startPoint.data = lastPoint.data;
        lastPoint.data = x;
    }

    public void  findSegment(Node root)
    {
     if(root == null)return;
     findSegment(root.left);
     if(prev != null)
     {
         if(prev.data  > root.data) {
             if (startPoint == null) {
                 startPoint = prev;
             }
             lastPoint = root;
         }
     }
     prev = root;
     findSegment(root.right);
    }

    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + "    ");
        inorder(root.right);
    }

    //Driver Program
    public static void main(String[] args)
    {
        RecoverBST tree = new RecoverBST();
        tree.root = new Node(10);
        tree.root.left = new Node(15);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(7);


        tree.root.right.left = new Node(14);
        tree.root.right.right = new Node(17);

        //Before Modification
        tree.inorder(tree.root);

        tree.recoverTree(tree.root);

        //After Modification
        System.out.print("\n");
        tree.inorder(tree.root);
    }
}
