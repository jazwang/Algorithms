public class Search {

    public static void main(String[] args)
    {
        int[] arr = { 38, 27, 43, 3, 9 ,82, 10};
        System.out.println(binarySearch(arr, 9)); //exists
        System.out.println(binarySearch(arr, 11)); //doesnt exist
    }

    static void BFS()
    {

    }

    static void DFS(){

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
