package Trees;

public class DiameterofBinaryTree {

    static class Pair<T,V>{
        T first;
        V second;
    }

    static  class Node{
        int data;
        Node left = null;
        Node right = null;

        Node(int d)
        {
            data = d;
        }
    }
   static Node root;

   static Pair<Integer,Integer> heightDiameter(Node root){
       if(root == null){
           Pair<Integer,Integer> output = new Pair<>();
           output.first = 0;
           output.second = 0;
           return output;
       }
       Pair<Integer,Integer> lo = heightDiameter(root.left);
       Pair<Integer,Integer> ro = heightDiameter(root.right);

       int height = 1+ Math.max(lo.first,ro.first);

       int option1 = lo.first + ro.first;
       int option2 = lo.second;
       int option3 = ro.second;

       int diameter = Math.max(option1, Math.max(option2,option3));

       Pair<Integer,Integer> output = new Pair<>();
       output.first = height;
       output.second = diameter;
       return output;
    }


    //Driver Program
    public static void main(String[] args)
    {
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.left.left = new Node(9);

        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right= new Node(7);

        root.right = new Node(3);

        System.out.println("Diameter of binary Tree is "+heightDiameter(root).second);

    }
}
