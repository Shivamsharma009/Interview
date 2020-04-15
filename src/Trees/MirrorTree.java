package Trees;

public class MirrorTree {
    static  Node root = null;
    static  class Node{
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


   static void getMirrorTree(Node root)
   {
       if(root == null)
           return;
       getMirrorTree(root.left);
       getMirrorTree(root.right);

       Node temp = root.left;
       root.left = root.right;
       root.right = temp;
   }

  static void inorder(Node root)
   {
       if(root!=null)
       {
           inorder(root.left);
           System.out.print(root.data+"   ");
           inorder(root.right);
       }
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

        inorder(root);
        getMirrorTree(root);
        System.out.print("\n");
        inorder(root);

    }
}
