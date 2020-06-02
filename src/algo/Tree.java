import javax.swing.tree.TreeCellRenderer;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean visited;
        List<TreeNode> neighbors;

        public TreeNode(int val)
        {
            this.val = val;
            this.left = null;
            this.right = null;
            this.visited = false;
            neighbors = new ArrayList<>();
        }
    }

    TreeNode root;

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node20 = new TreeNode(20);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node30 = new TreeNode(30);

        node5.left = node3;
        node5.right = node7;
        node20.right = node30;
        root.left = node5;
        root.right = node20;

        System.out.println("In-order: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.println("Pre-order:");
        preOrderTraversal(root);
        System.out.println();

        System.out.println("Post-order:");
        postOrderTraversal(root);
        System.out.println();

        System.out.println("Level-order:");
        levelOrderTraversal(root);
        System.out.println();
    }


    static void inOrderTraversal(TreeNode node)
    {
        if (node != null)
        {
            inOrderTraversal(node.left);
            System.out.print(node.val + " ");
            inOrderTraversal(node.right);
        }
    }

    static void preOrderTraversal(TreeNode node)
    {
        if (node != null)
        {
            System.out.print(node.val + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    static void postOrderTraversal(TreeNode node)
    {
        if (node != null)
        {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.val + " ");
        }
    }

    static void levelOrderTraversal(TreeNode node)
    {
        if (node == null)
        {
            return;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty())
        {
            TreeNode curr = queue.pop();
            System.out.print(curr.val + " ");
            if (curr.left != null)
            {
                queue.add(curr.left);
            }
            if (curr.right != null)
            {
                queue.add(curr.right);
            }
        }
    }
}
