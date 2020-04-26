package Trees;

public class MinDepthBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int d)
        {
            val = d;
        }
    }
    TreeNode root;

    public int getMinDepth(TreeNode root)
    {
        if(root == null) return 0;
        if(root.left == null && root.right == null)
            return 1;
        int leftDepth = root.left!=null ? getMinDepth(root.left):Integer.MAX_VALUE;
        int rightDepth = root.right!=null ? getMinDepth(root.right):Integer.MAX_VALUE;
        return  1 + Math.min(leftDepth,rightDepth);
    }

    //Driver Program
    public static void main(String[] args)
    {
        MinDepthBinaryTree tree = new MinDepthBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.left.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(5);

        int  res = tree.getMinDepth(tree.root);
        System.out.print("The Minimum Depth of a Binary Tree is "+res);
    }
}
