package Trees;

public class PrintNodesKDistanceRoot {

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

     static  Node root;

    static void KDistanceFromRoot(Node root,int k ,int dist)
    {
        if(root != null)
        {
            if(k == dist)
            {
                System.out.print(root.data+"    ");
                return;
            }
            KDistanceFromRoot(root.left,k,dist+1);
            KDistanceFromRoot(root.right,k,dist+1);
        }
    }

    //Driver Program
    public static void main(String[] args)
    {
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        KDistanceFromRoot(root,2,0);

    }
}
