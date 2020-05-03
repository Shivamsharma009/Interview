package Trees;

public class MaximumPathSum {


    static class Node{
        int data ;
        Node left = null;
        Node right = null;

        Node(int d)
        {
            data = d;
        }
    }
    static class Res{
        public int val;
    }

    Node root;

    private int findMaxTreePath(Node root, Res res)
    {
        if(root == null)
            return 0;

        int left = findMaxTreePath(root.left,res);
        int right = findMaxTreePath(root.right,res);

        //case 1
        int max_value = Math.max(Math.max(left,right) +root.data,root.data);

        //case 1 and 2 Compared
        int max_top = Math.max(max_value,root.data + left + right);

        //case 3
        res.val = Math.max(max_top,res.val);

        return  max_value;
    }

   public  int FindMaxSumPath(){

        // initialize res
      Res res = new Res();
      res.val = Integer.MIN_VALUE;

      findMaxTreePath(root,res);
       return  res.val;
    }

    //Driver Program
    public static void main(String[] args)
    {
        MaximumPathSum tree = new MaximumPathSum();
        tree.root = new Node(10);
        tree.root.left = new Node(2);

        tree.root.left.left = new Node(-4);
        tree.root.left.left.left = new Node(28);

        tree.root.left.left.right =new Node(-22);
        tree.root.left.right = new Node(-6);

        tree.root.right = new Node(15);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.right = new Node(4);
        tree.root.right.right.left = new Node(3);

        System.out.println("Maximum path Sum is "+tree.FindMaxSumPath());
    }
}


