package Trees;

public class AllNodeFromKDistanceFromGivenNode {
    static class Node {
        int data;
        Node left = null;
        Node right = null;

        Node(int d) {
            data = d;
        }
    }

    static Node root;
    static Node target;


    static void printKDistanceNodeDown(Node root, int k) {
        if (root == null || k < 0)
            return;
        if (k == 0) {
            System.out.print(root.data + "   ");
            return;
        }
        printKDistanceNodeDown(root.left, k - 1);
        printKDistanceNodeDown(root.right, k - 1);
    }

    static int printKDistanceFromNode(Node root, Node target, int k) {
        if (root == null)
            return -1;
        if (root == target) {
            printKDistanceNodeDown(root, k);
            return 0;
        }


        int dl = printKDistanceFromNode(root.left, target, k);
        if (dl != -1) {
            if (1 + dl == k) {
                System.out.print(root.data + "  ");
            } else {
                printKDistanceNodeDown(root.right, k - dl - 2);
                return 1 + dl;
            }
        }

        int dr = printKDistanceFromNode(root.right, target, k);
        if (dr != -1) {
            if (1 + dr == k) {
                System.out.print(root.data + "  ");
            } else {
                printKDistanceNodeDown(root.left, k - dr - 2);
                return 1 + dr;
            }
        }

        return -1;
    }

    //Driver Program
    public static void main(String[] args)
    {
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        root.left.left.left.left = new Node(5);
        root.left.left.left.left.left = new Node(6);
        root.left.left.left.left.right = new Node(7);

        root.left.right = new Node(8);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);

        root.right = new Node(11);

        target = root.left.left;

        int k = 3;

        printKDistanceFromNode(root,target,k);
    }
}
