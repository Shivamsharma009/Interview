package Trees;

public class SortedArrayToBST {
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

    public TreeNode constructArrayToBST(int[] nums)
    {
        if(nums.length == 0)
            return null;
        return constructTreeFromBST(nums,0,nums.length-1);
    }

    public TreeNode constructTreeFromBST(int[] nums,int left,int right)
    {
        if(left > right)
            return null;
        int midpoint = left +(right - left)/2;
        TreeNode node = new TreeNode(nums[midpoint]);
        node.left = constructTreeFromBST(nums,left,midpoint-1);
        node.right = constructTreeFromBST(nums,midpoint+1,right);

        return node;
    }

    public void inorder(TreeNode root)
    {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.val+"   ");
        inorder(root.right);
    }

    //Driver Program
    public static void main(String[] args)
    {
        SortedArrayToBST tree = new SortedArrayToBST();
        int[] nums = new int[]{-10,-5,-3,0,5,8,9};
        tree.root   = tree.constructArrayToBST(nums);
        System.out.println("The Constructed Binary Search Tree is");
        tree.inorder(tree.root);

    }
}
