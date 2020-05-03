package Trees;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class VerticalOrderUsingMAP {

   static class Node{
        int data;
        Node left = null;
        Node right = null;

        Node(int d){
            data = d;
        }
    }
    static  Node root;

    static void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> m)
    {
        if(root == null)
            return;

        Vector<Integer> get = m.get(hd);

        if(get == null)
        {
            get = new Vector<>();
            get.add(root.data);
        }
        else{
            get.add(root.data);
        }

        m.put(hd,get);

        getVerticalOrder(root.left,hd-1,m);
        getVerticalOrder(root.right,hd+1,m);
    }

    static void PrintVerticalOrder(Node root)
    {
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(root,hd,m);

        for(Map.Entry<Integer,Vector<Integer>> entry : m.entrySet())
            System.out.println(entry.getValue());
    }

    //Driver Program
    public static  void main(String[] args)
    {
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(8);

        root.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(6);

        System.out.println("Vertical order of a Binary Tree is ");

        PrintVerticalOrder(root);
    }

}
