package Trees;

public class CheckIsIdentical {
    private static Node root1,root2 = null;
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

   private static boolean IsIdentical(Node root1, Node root2)
    {
        if(root1 == null && root2 == null)
            return true;
            if (root1!=null && root2!=null){
                return(root1.data == root2.data)&&IsIdentical(root1.left,root2.left)&&IsIdentical(root1.right,root2.right);
            }

        return false;
    }

    //Driver Program
    public static  void main(String[] args){
        root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(4);

        root1.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(3);
        root2.left.right = new Node(4);

        root2.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);

       boolean res = IsIdentical(root1,root2);

       if(res)
           System.out.println("Both Trees are Identical");
       else
           System.out.println("Trees are Not Identical");
    }
}
