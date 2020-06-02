import java.util.ArrayDeque;
import java.util.Deque;

public class Search {

    public static void main(String[] args)
    {
        int[] arr = { 38, 27, 43, 3, 9 ,82, 10};
        System.out.println(binarySearch(arr, 9)); //exists
        System.out.println(binarySearch(arr, 11)); //doesnt exist
    }

    // Graph Search

    /*
        Breadth-first Search (Level-order Traversal)

        Used for finding shortest path between two nodes
        *** Is NOT recursive
        uses a queue
     */
    static void BFS(Tree.TreeNode root)
    {
        Deque<Tree.TreeNode> queue = new ArrayDeque<>();

        if (root == null)
        {
            return;
        }

        root.visited = true;
        queue.add(root);

        while (!queue.isEmpty())
        {
            Tree.TreeNode curr = queue.pop();
            for (Tree.TreeNode neighbor : curr.neighbors)
            {
                if (!neighbor.visited)
                {
                    neighbor.visited = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    /*
        Depth-first Search
     */
    static void DFS(Tree.TreeNode root){
        if (root == null)
        {
            return;
        }
        root.visited = true;
        for (Tree.TreeNode neighbor: root.neighbors)
        {
            if (!neighbor.visited)
            {
                DFS(neighbor);
            }
        }
    }

    /*
        - Binary Search -
        look for target in a sorted array
        first compare target to midpoint of array
        if less than midpoint, search first half
        else, search second half

        *** how about recursion?

        Runtime: O(logn)
        Memory: O(1)
     */
    static int binarySearch(int[] arr, int target)
    {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right)
        {
            mid = (left + right) / 2;
            if (target < arr[mid])
            {
                right = mid -1;
            }
            else if (target > arr[mid])
            {
                left = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}
